package consonants.flex.use_case.view_forms_dashboard;

import consonants.flex.entity.Form;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ViewFormsDashboardInputBoundary {
    ResponseEntity<List<Form>> execute(ViewFormsDashboardInputData inputData);
}
