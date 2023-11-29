package consonants.flex.use_case.view_forms_dashboard;

import consonants.flex.entity.Form;

import java.util.List;

public interface ViewFormsDashboardDataAccessInterface {

    List<Form> getFormsListAsForms(int clientId, int claimId);
}
