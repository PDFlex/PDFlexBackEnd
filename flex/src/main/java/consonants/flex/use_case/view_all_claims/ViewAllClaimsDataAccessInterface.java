package consonants.flex.use_case.view_all_claims;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;

import java.util.ArrayList;
import java.util.List;

public interface ViewAllClaimsDataAccessInterface {

    Claim createClaim(int clientId);

    List<Claim> allClaims();
}
