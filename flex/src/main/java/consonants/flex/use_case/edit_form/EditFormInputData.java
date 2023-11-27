package consonants.flex.use_case.edit_form;

import lombok.Getter;

import java.util.Map;

@Getter
public class EditFormInputData {
    final private Map<String, Object> formFields;
    final private String name;
    final private int claimId;

    public EditFormInputData(Map<String, Object> formFields, String name, int claimId) {
        this.formFields = formFields;
        this.name = name;
        this.claimId = claimId;
    }
}
