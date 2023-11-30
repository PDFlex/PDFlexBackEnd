package consonants.flex.use_case.view_claims_dashboard;

import consonants.flex.entity.Claim;

import java.util.List;

public class ViewClaimsDashboardOutputData {
    private final List<Claim> claims;

    public ViewClaimsDashboardOutputData(List<Claim> claims) {this.claims = claims;}

    public List<Claim> getClaims() {return this.claims;}
}
