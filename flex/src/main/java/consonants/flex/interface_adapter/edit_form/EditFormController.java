package consonants.flex.interface_adapter.edit_form;

import consonants.flex.use_case.edit_form.EditFormInputBoundary;
import consonants.flex.use_case.edit_form.EditFormInputData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/edit-form")

public class EditFormController {
    @Autowired // Does this rid the need for a constructor? Also why error?
    private EditFormInputBoundary editFormUseCaseInteractor;

    // TODO: Recreate post and get mappings
    // TODO: Do we need a controller
    @PostMapping
    public ResponseEntity<Object> getFormInfo(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public void execute() {
        EditFormInputData editFormInputData = new EditFormInputData(); //take input data as parameters
        editFormUseCaseInteractor.execute(editFormInputData);
    }
}
