package consonants.flex.interface_adapter.view_forms_dashboard;

import consonants.flex.entity.Form;
import consonants.flex.use_case.view_forms_dashboard.ViewFormsDashboardOutputBoundary;
import consonants.flex.use_case.view_forms_dashboard.ViewFormsDashboardOutputData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewFormsDashboardPresenter implements ViewFormsDashboardOutputBoundary {
    @Override
    public List<Form> viewForms(ViewFormsDashboardOutputData outputData) {return outputData.getForms();}
}
