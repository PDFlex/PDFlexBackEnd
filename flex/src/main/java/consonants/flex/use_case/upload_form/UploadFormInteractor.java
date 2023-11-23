package consonants.flex.use_case.upload_form;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsOutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController

public class UploadFormInteractor implements UploadFormInputBoundary{


    @Autowired
    final UploadFormDataAccessInterface uploadDataAccessObject;
//    final UploadFormOutputBoundary uploadPresenter;

    public UploadFormInteractor(UploadFormDataAccessInterface uploadDataAccessObject) {
        this.uploadDataAccessObject = uploadDataAccessObject;
    }

    @Override
    public void execute(UploadFormInputData uploadInputData) throws Exception{
        // TODO: figure out how to go claimId -> formId, for now we'll hard code the formID
        // TODO: should create a method in the DAO that retrieves the BSON pdf -> base64 pdf (we'll need to change the input name)

        Map<String, Object> formFields = uploadDataAccessObject.OCRLCInfoRequestCall(uploadInputData.getBase64());

        uploadDataAccessObject.modifyForm(1001, formFields);
    }
}
