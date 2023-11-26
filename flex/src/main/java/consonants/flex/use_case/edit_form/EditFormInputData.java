package consonants.flex.use_case.edit_form;

import java.util.Map;

public class EditFormInputData {
    Map<String, Object> formInfo; // Why does the variable get greyed out when I use private final?

    // Data manipulation
    public EditFormInputData(Map<String, Object> formInfo) {
        this.formInfo = formInfo;
    }
}
