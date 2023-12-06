package consonants.flex.interface_adapter.retrieve_form;

import consonants.flex.entity.Form;
import consonants.flex.use_case.retrieve_form.RetrieveFormInputBoundary;
import consonants.flex.use_case.retrieve_form.RetrieveFormInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/form-info")
public class RetrieveFormController {
    @Autowired
    private RetrieveFormInputBoundary retrieveFormInteractor;

    @GetMapping("/{claimId}/retrieve")
    public ResponseEntity<Form> RetrieveFormInfo(@PathVariable int claimId) {

        RetrieveFormInputData inputData = new RetrieveFormInputData(claimId);
        return retrieveFormInteractor.execute(inputData);
    }
}
