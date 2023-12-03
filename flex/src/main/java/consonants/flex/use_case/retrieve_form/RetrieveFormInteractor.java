package consonants.flex.use_case.retrieve_form;

import consonants.flex.entity.Form;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetrieveFormInteractor implements RetrieveFormInputBoundary {
    private final RetrieveFormDataAccessInterface retrieveFormDataAccessObject;
    private final RetrieveFormOutputBoundary retrieveFormPresenter;
    public RetrieveFormInteractor(RetrieveFormDataAccessInterface retrieveFormDataAccessObject, RetrieveFormOutputBoundary retrieveFormPresenter) {
        this.retrieveFormDataAccessObject = retrieveFormDataAccessObject;
        this.retrieveFormPresenter = retrieveFormPresenter;
    }
    @Override
    public ResponseEntity<Form> execute(RetrieveFormInputData inputData) {
        Form form = retrieveFormDataAccessObject.getFirstForm(inputData.claimId);
        RetrieveFormOutputData outputData = new RetrieveFormOutputData(form);
        return new ResponseEntity<>(retrieveFormPresenter.retrieveForm(outputData), HttpStatus.OK);
    }
}
