package consonants.flex.use_case.retrieve_form;

import consonants.flex.entity.Form;
import org.springframework.http.ResponseEntity;

public interface RetrieveFormInputBoundary {
    ResponseEntity<Form> execute(RetrieveFormInputData inputData);

}
