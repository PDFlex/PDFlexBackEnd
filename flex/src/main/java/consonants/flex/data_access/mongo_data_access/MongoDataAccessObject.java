package consonants.flex.data_access.mongo_data_access;


import com.mongodb.client.model.Filters;
import consonants.flex.entity.*;
import consonants.flex.use_case.upload_form.UploadFormDataAccessInterface;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsDataAccessInterface;
import org.bson.conversions.Bson;
import org.bson.types.Binary;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class MongoDataAccessObject implements ViewAllClaimsDataAccessInterface, UploadFormDataAccessInterface {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private FormRepository formRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Client> allClients() {return clientRepository.findAll();}
    public List<Claim> allClaims() {return claimRepository.findAll();}
    public List<Form> allForms() {return formRepository.findAll();}
    public List<FileDocument> allDocuments() {return documentRepository.findAll();}


    public Client createClient(int clientId, String firstName, String lastName) {
        Client client = clientRepository.insert(new Client(clientId, firstName, lastName));
        return client;
    }

    public Claim createClaim(ArrayList<Form> forms, int status, int clientId, int claimId) {
        Claim claim = claimRepository.insert(new Claim(forms, status, clientId, claimId));

        mongoTemplate.update(Client.class)
                .matching(Criteria.where("clientId").is(clientId))
                .apply(new Update().push("claimsList").value(claimId))
                .first();

        return claim;
    }

    public Form createForm(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned) {
        Form form = formRepository.insert(new Form(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned));

        mongoTemplate.update(Claim.class)
                .matching(Criteria.where("claimId").is(claimId))
                .apply(new Update().push("forms").value(formId))
                .first();

        return form;
    }

    public Optional<Client> findClient(int clientId) {
//        The below commented out method body works. It may be a better way to deal with null returns. i.e. when lst is empty.
//        Query query = new Query();
//        query.addCriteria(Criteria.where("clientId").is(clientId));
//        List<Client> lst = mongoTemplate.find(query, Client.class);
//        return lst.get(0);
        Optional<Client> client = clientRepository.findClientByClientId(clientId);
        return client;
    }

    public Optional<Claim> findClaim(int claimId) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("claimId").is(claimId));
//        Claim claim = (Claim) mongoTemplate.find(query, Claim.class);
        Optional<Claim> claim = claimRepository.findClaimByClaimId(claimId);
        return claim;
    }

    public Optional<Form> findForm(int formId) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("formId").is(formId));
//        Form form = (Form) mongoTemplate.find(query, Form.class);
        Optional<Form> form = formRepository.findFormByFormId(formId);
        return form;
    }

    public boolean loginClientExists(int clientId, String firstName, String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        query.addCriteria(Criteria.where("firstName").is(firstName));
        query.addCriteria(Criteria.where("lastName").is(lastName));
        List<Client> lst = mongoTemplate.find(query, Client.class);

        if (!lst.isEmpty()) {
            return true;
        }
        return false;
    }
    public Client modifyFirstName(int clientId, String newFirstName) {
        // Like previous method, this finds a Client using a criteria. This method is pre-set
        // to the firstName field. Returns a Client Object.
        // can change return type of modifyFirstName as needed
        Query query = new Query().addCriteria(Criteria.where("clientId").is(clientId));
        Update updateDefinition = new Update().set("firstName", newFirstName);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);

        return mongoTemplate.findAndModify(query, updateDefinition, options, Client.class);
    }



    public void modifyForm(int claimId, Map<String, Object> formFields) {

        for (Map.Entry<String, Object> formField : formFields.entrySet()) {
            // access form we want to populate by formId
            Query query = new Query().addCriteria(Criteria.where("claimId").is(claimId));

            Update updateDefinition = new Update().set(formField.getKey(), formField.getValue());
            FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);

            mongoTemplate.findAndModify(query, updateDefinition, options, Form.class, "forms");

        }
    }

    // extracts base64 string from the documents collection for the relevant claim
    @Override
    public Binary extractPDFBase64(int claimId) {
        // retrieve document object, so we can get the value from the "content" key

        Query query = new Query().addCriteria(Criteria.where("claimId").is(claimId));

        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);
        System.out.println("TESTTT");
        List<FileDocument> docs = mongoTemplate.find(query, FileDocument.class, "documents");
//        for(FileDocument doc : docs){
//            System.out.println(doc.getContent().toString());
//        }
        String binaryStr = docs.get(0).getContent().toString(); //TODO: check if this violates CA
        System.out.println(binaryStr);
        return docs.get(0).getContent();

    }

    public Map<String, Object> OCRLCInfoRequestCall(Binary base64PDF) throws Exception{ // TODO: look into `throws Exception`

        SearchablePDF runSearchablePDF = new SearchablePDF(base64PDF);
        DocumentIntelligence runDocIntelligence = new DocumentIntelligence();

        // OCRSpace creates searchable pdf url so Azure OCR can accept the input and return the form fields mapping
        String pdfUrl = runSearchablePDF.sendPost();
        return runDocIntelligence.OCRLCInfoRequest(pdfUrl);
    }
}
