package consonants.flex.use_case.view_claims_dashboard;

import consonants.flex.entity.Claim;

import java.util.List;

public interface ViewClaimsDashboardOutputBoundary {
    List<Claim> viewClaims(ViewClaimsDashboardOutputData outputData);
}
