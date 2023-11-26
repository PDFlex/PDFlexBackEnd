package consonants.flex.use_case.upload_form;

import consonants.flex.data_access.mongo_data_access.DocumentRepository;
import consonants.flex.data_access.mongo_data_access.FileDataAccess;
import consonants.flex.data_access.mongo_data_access.NetworkDataAccess;
import consonants.flex.entity.Claim;
import consonants.flex.entity.FileDocument;
import consonants.flex.entity.Form;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsOutputData;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@RestController

public class UploadFormInteractor implements UploadFormInputBoundary{


    @Autowired
    final UploadFormDataAccessInterface uploadDataAccessObject;
    @Autowired
    private DocumentRepository documentRepository;
//    final UploadFormOutputBoundary uploadPresenter;

    public UploadFormInteractor(UploadFormDataAccessInterface uploadDataAccessObject) {
        this.uploadDataAccessObject = uploadDataAccessObject;
    }

    @Override
    public void execute(UploadFormInputData uploadInputData) throws Exception{
        // TODO: figure out how to get claimId from the frontend, for now we'll hard code the claimId
        Map<String, Object> formFields = uploadDataAccessObject.OCRLCInfoRequestCall();
        uploadDataAccessObject.modifyForm(24, formFields);
    }
}
