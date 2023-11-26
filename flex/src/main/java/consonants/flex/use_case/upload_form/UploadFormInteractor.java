package consonants.flex.use_case.upload_form;

import consonants.flex.data_access.mongo_data_access.FileDataAccess;
import consonants.flex.data_access.mongo_data_access.NetworkDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
        Map<String, Object> formFields = uploadDataAccessObject.OCRLCInfoRequestCall();
        uploadDataAccessObject.modifyForm(1007890, formFields);
    }
}
