package consonants.flex.use_case.edit_form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditFormInteractor implements EditFormInputBoundary{

    @Autowired
    final EditFormDataAccessInterface editFormDataAccessObject;

    public EditFormInteractor(EditFormDataAccessInterface editFormDataAccessObject) {
        this.editFormDataAccessObject = editFormDataAccessObject;
    }

    @Override
    public ResponseEntity<Object> execute(EditFormInputData editFormInputData) {

        // TODO: Update form as required
        return new ResponseEntity<>("Form Information: ", HttpStatus.OK);
    }
}
