package consonants.flex.use_case.save_form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveFormInteractor implements SaveFormInputBoundary{
    @Autowired
    final SaveFormDataAccessInterface saveFormDataAccessObject;

    public SaveFormInteractor(SaveFormDataAccessInterface saveFormDataAccessObject) {
        this.saveFormDataAccessObject = saveFormDataAccessObject;
    }

    @Override
    public ResponseEntity<Object> execute(SaveFormInputData saveFormInputData) {
        saveFormDataAccessObject.modifyForm(saveFormInputData.getClaimId(), saveFormInputData.getFormFields());
        return new ResponseEntity<>("Form Information: " + saveFormInputData.getFormFields(), HttpStatus.OK);
    }
}
