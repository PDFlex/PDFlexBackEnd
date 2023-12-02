package consonants.flex.data_access.mongo_data_access;

import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClient;
import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClientBuilder;
import com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult;
import com.azure.ai.formrecognizer.documentanalysis.models.DocumentKeyValuePair;
import com.azure.ai.formrecognizer.documentanalysis.models.OperationResult;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.polling.SyncPoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentIntelligence {

    public Map<String, Object> OCRLCInfoRequest(String pdfURL) {

        String endpoint = "https://pdflex.cognitiveservices.azure.com/";
        String key = "c2ec275a27df4c219daa3a547dc3965f";

        // create your `DocumentAnalysisClient` instance and `AzureKeyCredential` variable
        DocumentAnalysisClient client = new DocumentAnalysisClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();

        String documentUrl = pdfURL;
        String modelId = "prebuilt-document";
        SyncPoller<OperationResult, AnalyzeResult> analyzeDocumentPoller =
                client.beginAnalyzeDocumentFromUrl(modelId, documentUrl);

        // OCR result
        AnalyzeResult analyzeResult = analyzeDocumentPoller.getFinalResult();
        // store the key-value pairs
        List<DocumentKeyValuePair> keyValuePairs = analyzeResult.getKeyValuePairs();

        // mapping to store our key-value pairs
        Map<String, Object> formFields = new HashMap<>();

        // for values in key-value pairs that are arrays
        ArrayList<String> pastPhysicianNames = new ArrayList<>();
        ArrayList<String> pastPhysicianAddresses = new ArrayList<>();

        // counters to keep track of duplicate keys
        int telephoneCounter = 0;
        int addressCounter = 0;
        int fullAddressCounter = 0;

        for (DocumentKeyValuePair keyValuePair : keyValuePairs) {
            if (keyValuePair.getValue() != null) {
                // claims checklist
                if (keyValuePair.getKey().getContent().equals("Has the Certification of Death form been completed by the attending physician, coroner, or family doctor?")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    if (formFieldValue.equals(":selected:")) {
                        formFields.put("completedDeathCertificate", true);
                    }
                } else if (keyValuePair.getKey().getContent().equals("Attach an original or a copy of the death certificate.")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    if (formFieldValue.equals(":selected:")) {
                        formFields.put("attachedDeathCertificate", true);
                    }
                } else if (keyValuePair.getKey().getContent().equals("Has the lender either completed the claim submission online or completed the Statement of Lending Institution form?")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    if (formFieldValue.equals(":selected:")) {
                        formFields.put("completedClaimSubmission", true);
                    }
                }
                else if (keyValuePair.getKey().getContent().equals("Name of deceased (first, middle, last)")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("deceasedName", formFieldValue);

                } else if (keyValuePair.getKey().getContent().equals("Date of birth (mo/day/yr)")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("dateOfBirth", formFieldValue);

                } else if (keyValuePair.getKey().getContent().equals("Date of death (mo/day/yr)")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("dateOfDeath", formFieldValue);

                } else if (keyValuePair.getKey().getContent().equals("Cause of death")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("causeOfDeath", formFieldValue);

                } else if (keyValuePair.getKey().getContent().equals("If yes, date admitted:")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("deceasedHospitalized", true);
                    formFields.put("hospitalizationDate", formFieldValue);

                } else if (keyValuePair.getKey().getContent().equals("Name of hospital")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("hospitalName", formFieldValue);

                } else if (keyValuePair.getKey().getContent().equals("Address (street, city, province, postal code)") && fullAddressCounter == 0) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("hospitalAddress", formFieldValue);
                    fullAddressCounter++;

                } else if (keyValuePair.getKey().getContent().equals("Name of attending physician at time of death")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("attendingPhysicianName", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Address (street, city, province, postal code)") && fullAddressCounter == 1) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("attendingPhysicianAddress", formFieldValue);
                    fullAddressCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Telephone number") && telephoneCounter == 0) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("attendingPhysicianContactNumber", formFieldValue);
                    telephoneCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Name of family physician")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("familyPhysicianName", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Address (street, city, province, postal code)") && fullAddressCounter == 2) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("familyPhysicianAddress", formFieldValue);
                    fullAddressCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Telephone number") && telephoneCounter == 1) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("familyPhysicianContactNumber", formFieldValue);
                    telephoneCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Physician name")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    pastPhysicianNames.add(formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Address") && addressCounter != 3) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    pastPhysicianAddresses.add(formFieldValue);
                    addressCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Address")){
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("kinAddress", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Occupation")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("occupation", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Date last worked (mo/day/yr)")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("dateLastWorked", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Employer")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("employer", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Address (street, city, province, postal code)") && fullAddressCounter == 3) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("workAddress", formFieldValue);
                    fullAddressCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Telephone number") && telephoneCounter == 2) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("employerContactNumber", formFieldValue);
                    telephoneCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Name of next-of-kin")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("nameOfKin", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Relationship to insured")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("relationshipToInsured", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Telephone number") && telephoneCounter == 3) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("kinContactNumber", formFieldValue);
                    telephoneCounter++;
                } else if (keyValuePair.getKey().getContent().equals("Signature of next-of-kin")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("kinSignature", formFieldValue);
                } else if (keyValuePair.getKey().getContent().equals("Date signed (mo/day/yr)")) {
                    String formFieldValue = keyValuePair.getValue().getContent();
                    formFields.put("dateSigned", formFieldValue);
                }

                if (keyValuePair.getKey().getContent().equals("Normal retirement") && keyValuePair.getValue().getContent().equals(":selected:")) {
                    formFields.put("reasonInsuredStoppedWorking", "Normal retirement");
                } else if (keyValuePair.getKey().getContent().equals("Disability retirement") && keyValuePair.getValue().getContent().equals(":selected:")) {
                    formFields.put("reasonInsuredStoppedWorking", "Disability retirement");
                } else if (keyValuePair.getKey().getContent().equals("Illness") && keyValuePair.getValue().getContent().equals(":selected:")) {
                    formFields.put("reasonInsuredStoppedWorking", "Illness");
                } else if (keyValuePair.getKey().getContent().equals("Death") && keyValuePair.getValue().getContent().equals(":selected:")) {
                    formFields.put("reasonInsuredStoppedWorking", "Death");
                } else if (keyValuePair.getKey().getContent().equals("Other (please specify)") && keyValuePair.getValue().getContent().equals(":selected:")) {
                    String formFieldValue = (keyValuePair.getKey().getContent()).replaceAll("Other (please specify):", "");
                    formFields.put("reasonInsuredStoppedWorking", formFieldValue);
                }
            } else if (keyValuePair.getValue() == null){
                if (keyValuePair.getKey().getContent().equals("Address")){
                    addressCounter ++;
                } else if (keyValuePair.getKey().getContent().equals("Telephone number")){
                    telephoneCounter ++;
                }
                else if (keyValuePair.getKey().getContent().equals("Address (street, city, province, postal code)")){
                    fullAddressCounter++;
                }
            }

            formFields.put("pastPhysicianNames", pastPhysicianNames);
            formFields.put("pastPhysicianAddresses", pastPhysicianAddresses);

        }

    //     for (Map.Entry<String, Object> entry : formFields.entrySet()) {
    //         System.out.println(entry.getKey() + ": " + entry.getValue());
    // }

        return formFields;
        }
    }

