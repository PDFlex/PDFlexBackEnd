package consonants.flex.use_case.upload_form;

import consonants.flex.entity.*;

import java.util.Optional;

public interface UploadFormDataAccessInterface{
    // access the relevant form object
    Optional<Form> findForm(int formId);

    // run the appropriate OCR algorithm depending on the form type
    void OCRLCInfoRequest (LCInfoRequest lifeClaimInfoRequestForm, String pdfURL);
    void OCRLCInitiation (LCInitiation lifeClaimInitiationForm, String pdfURL);
    void OCRPhysicianStatement (PhysicianStatement physicianStatementForm, String pdfURL);

}
