package consonants.flex.use_case.create_new_claim;

import lombok.Getter;

@Getter
public class CreateNewClaimOutputData {
    /**
     * Stores the claim id generated
     */
    int claimId;

    public CreateNewClaimOutputData(int claimId) {
        this.claimId = claimId;
    }

}
