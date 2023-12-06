package consonants.flex.use_case.save_form;

import org.springframework.http.ResponseEntity;

public interface SaveFormInputBoundary {
    ResponseEntity<Object> execute(SaveFormInputData saveFormInputData);
}