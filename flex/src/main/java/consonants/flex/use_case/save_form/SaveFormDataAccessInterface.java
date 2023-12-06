package consonants.flex.use_case.save_form;

import java.util.List;
import java.util.Map;

public interface SaveFormDataAccessInterface {
    void modifyForm(int claimId, Map<String, Object> formFields);

    List<Integer> getClaimFormIds(int claimId);

    Boolean modifyFormStatus(int formId, String status);
}
