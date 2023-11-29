package consonants.flex.use_case.create_new_claim;
import consonants.flex.entity.Claim;

public interface CreateNewClaimDataAccessInterface {

    Claim createClaim(int clientId);
}