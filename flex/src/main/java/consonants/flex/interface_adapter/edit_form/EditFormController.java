package consonants.flex.interface_adapter.edit_form;

import consonants.flex.use_case.edit_form.EditFormInputBoundary;
import consonants.flex.use_case.edit_form.EditFormInputData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/form-info")

public class EditFormController {
    @Autowired
    private EditFormInputBoundary editFormUseCaseInteractor;

    @PostMapping("/post")
    public ResponseEntity<Object> getFormInfo(@RequestParam("form") Map<String, Object> formFields,
                                              @RequestParam("formName") String name,
                                              @RequestParam("claimId") int claimId){
        EditFormInputData editFormInputData = new EditFormInputData(formFields, name, claimId);
        return editFormUseCaseInteractor.execute(editFormInputData);
    }
}
