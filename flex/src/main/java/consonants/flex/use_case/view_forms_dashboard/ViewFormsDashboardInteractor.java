package consonants.flex.use_case.view_forms_dashboard;

import consonants.flex.entity.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewFormsDashboardInteractor implements ViewFormsDashboardInputBoundary {
    @Autowired
    private final ViewFormsDashboardDataAccessInterface formDataAccessObject;

    @Autowired
    private final ViewFormsDashboardOutputBoundary viewFormsDashboardPresenter;

    public ViewFormsDashboardInteractor(ViewFormsDashboardDataAccessInterface formDataAccessObject, ViewFormsDashboardOutputBoundary viewFormsDashboardPresenter) {
        this.formDataAccessObject = formDataAccessObject;
        this.viewFormsDashboardPresenter = viewFormsDashboardPresenter;
    }

    @Override
    public ResponseEntity<List<Form>> execute(ViewFormsDashboardInputData inputData) {
        int clientId = inputData.getClientId();
        int claimId = inputData.getClaimId();
        List<Form> forms = formDataAccessObject.getFormsListAsForms(clientId, claimId);
        ViewFormsDashboardOutputData outputData = new ViewFormsDashboardOutputData(forms);
        return new ResponseEntity<>(viewFormsDashboardPresenter.viewForms(outputData), HttpStatus.OK);
    }
}
