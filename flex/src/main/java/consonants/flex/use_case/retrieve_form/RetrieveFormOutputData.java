package consonants.flex.use_case.retrieve_form;

import consonants.flex.entity.Form;
import lombok.Getter;

@Getter
public class RetrieveFormOutputData {

    Form form;
    public RetrieveFormOutputData(Form form) {
        this.form = form;
    }
}
