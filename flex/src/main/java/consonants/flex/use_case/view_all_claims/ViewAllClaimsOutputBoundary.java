package consonants.flex.use_case.view_all_claims;

import consonants.flex.entity.Claim;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ViewAllClaimsOutputBoundary {

    List<Claim> viewAllClaims(ViewAllClaimsOutputData outputData);
}
