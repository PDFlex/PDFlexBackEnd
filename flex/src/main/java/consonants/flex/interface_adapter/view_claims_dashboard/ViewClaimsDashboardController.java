package consonants.flex.interface_adapter.view_claims_dashboard;

import consonants.flex.entity.Claim;
import consonants.flex.use_case.view_claims_dashboard.ViewClaimsDashboardInputBoundary;
import consonants.flex.use_case.view_claims_dashboard.ViewClaimsDashboardInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{clientId}")
public class ViewClaimsDashboardController {
    @Autowired
    private ViewClaimsDashboardInputBoundary viewClaimsDashboardInteractor;

    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> viewClaims(@PathVariable int clientId) {
        ViewClaimsDashboardInputData inputData = new ViewClaimsDashboardInputData(clientId);
        return viewClaimsDashboardInteractor.execute(inputData);
    }
}
