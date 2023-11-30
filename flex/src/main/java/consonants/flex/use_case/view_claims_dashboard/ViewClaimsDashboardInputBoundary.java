package consonants.flex.use_case.view_claims_dashboard;

import consonants.flex.entity.Claim;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ViewClaimsDashboardInputBoundary {
    ResponseEntity<List<Claim>> execute(ViewClaimsDashboardInputData inputData);
}
