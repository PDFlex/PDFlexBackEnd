package consonants.flex.use_case.create_new_claim;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;

import java.util.ArrayList;

public interface CreateNewClaimDataAccessInterface {

    Claim createClaim(ArrayList<Form> forms, int status, int clientId, int claimId);
}
