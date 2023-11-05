package consonants.flex.use_case.create_new_claim;

public interface CreateNewClaimOutputBoundary {
    void prepareSuccessView(CreateNewClaimOutputData newClaim);

    void prepareFailView(String error);

}
