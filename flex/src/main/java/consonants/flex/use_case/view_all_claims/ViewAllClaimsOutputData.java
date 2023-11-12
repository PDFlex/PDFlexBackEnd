package consonants.flex.use_case.view_all_claims;

import consonants.flex.entity.Claim;

import java.util.List;

public class ViewAllClaimsOutputData {
    private final List<Claim> claims;

    public ViewAllClaimsOutputData(List<Claim> claims) {this.claims = claims;}

    public List<Claim> getAllClaims() {return claims;}
}
