package consonants.flex.use_case.view_forms_dashboard;

import consonants.flex.entity.Form;

import java.util.List;

public interface ViewFormsDashboardOutputBoundary {
    List<Form> viewForms(ViewFormsDashboardOutputData outputData);
}
