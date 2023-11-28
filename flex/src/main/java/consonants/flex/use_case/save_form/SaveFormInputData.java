package consonants.flex.use_case.save_form;

import lombok.Getter;

import java.util.Map;

@Getter
public class SaveFormInputData {
    final private Map<String, Object> formFields;

    final private int claimId;

    public SaveFormInputData(Map<String, Object> formFields) {
        this.formFields = formFields;
        this.claimId = Integer.parseInt((String) formFields.get("claimId"));
    }
}
