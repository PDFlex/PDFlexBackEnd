package consonants.flex.use_case.save_form;

import lombok.Getter;

import java.util.Map;

@Getter
public class SaveFormInputData {
    final private Map<String, Object> formFields;

    final private int claimId;

    public SaveFormInputData(Map<String, Object> formFields, int claimId) {
        this.formFields = formFields;
        this.claimId = claimId;
    }
}
