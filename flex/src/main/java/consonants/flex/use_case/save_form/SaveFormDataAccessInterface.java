package consonants.flex.use_case.save_form;

import java.util.Map;

public interface SaveFormDataAccessInterface {
    void modifyForm(int claimId, Map<String, Object> formFields);
}
