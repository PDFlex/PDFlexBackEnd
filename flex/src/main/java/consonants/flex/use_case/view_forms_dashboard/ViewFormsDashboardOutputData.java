package consonants.flex.use_case.view_forms_dashboard;

import consonants.flex.entity.Form;

import java.util.List;

public class ViewFormsDashboardOutputData {
    private final List<Form> forms;

    public ViewFormsDashboardOutputData(List<Form> forms) {this.forms = forms;}

    public List<Form> getForms() {return this.forms;}
}
