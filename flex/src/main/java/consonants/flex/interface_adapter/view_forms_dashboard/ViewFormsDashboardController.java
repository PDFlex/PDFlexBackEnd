package consonants.flex.interface_adapter.view_forms_dashboard;

import consonants.flex.entity.Form;
import consonants.flex.use_case.view_forms_dashboard.ViewFormsDashboardInputBoundary;
import consonants.flex.use_case.view_forms_dashboard.ViewFormsDashboardInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{clientId}/{claimId}")
public class ViewFormsDashboardController {
    @Autowired
    private ViewFormsDashboardInputBoundary viewFormsDashboardInteractor;

    @GetMapping("/forms")
    public ResponseEntity<List<Form>> viewClaims(@PathVariable int clientId, @PathVariable int claimId) {
        ViewFormsDashboardInputData inputData = new ViewFormsDashboardInputData(clientId, claimId);
        return viewFormsDashboardInteractor.execute(inputData);
    }
}
