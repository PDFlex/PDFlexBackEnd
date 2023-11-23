package consonants.flex.use_case.upload_form;

import consonants.flex.entity.*;

import java.util.Map;
import java.util.Optional;

public interface UploadFormDataAccessInterface{
    // access the relevant form object through the claim
    Optional<Claim> findClaim(int claimId);
    Optional<Form> findForm(int formId);

    // run the OCR algorithm
    Map<String, Object> OCRLCInfoRequestCall(String pdfUrl) throws Exception;

    // find an existing form object, so we can populate it with the OCR result
    void modifyForm(int claimId, Map<String, Object> formFields);


}
