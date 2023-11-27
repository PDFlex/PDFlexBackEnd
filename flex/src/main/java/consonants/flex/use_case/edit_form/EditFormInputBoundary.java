package consonants.flex.use_case.edit_form;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EditFormInputBoundary {
    ResponseEntity<Object> execute(EditFormInputData editFormInputData);
}