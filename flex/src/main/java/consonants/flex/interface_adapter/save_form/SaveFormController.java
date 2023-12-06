package consonants.flex.interface_adapter.save_form;

import consonants.flex.use_case.save_form.SaveFormInputBoundary;
import consonants.flex.use_case.save_form.SaveFormInputData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/form-info")

public class SaveFormController {
    @Autowired
    private final SaveFormInputBoundary saveFormUseCaseInteractor;

    public SaveFormController(SaveFormInputBoundary saveFormUseCaseInteractor) {
        this.saveFormUseCaseInteractor = saveFormUseCaseInteractor;
    }

    @PostMapping("/{claimId}")
    public ResponseEntity<Object> getFormInfo(@RequestBody Map<String, Object> formFields, @PathVariable int claimId){
        SaveFormInputData saveFormInputData = new SaveFormInputData(formFields, claimId);
        return saveFormUseCaseInteractor.execute(saveFormInputData);
    }
}
