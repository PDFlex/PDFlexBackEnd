package consonants.flex.use_case.edit_form;

import org.springframework.stereotype.Service;

@Service
public interface EditFormInputBoundary {
    void execute(EditFormInputData editFormInputData);
}
