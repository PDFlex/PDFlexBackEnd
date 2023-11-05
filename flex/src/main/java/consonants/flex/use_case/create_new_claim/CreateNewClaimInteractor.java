package consonants.flex.use_case.create_new_claim;

public class CreateNewClaimInteractor implements CreateNewClaimInputBoundary{
    final CreateNewClaimDataAccessInterface createNewClaimDataAccessObject;
//    final CreateNewClaimOutputBoundary CreateNewClaimPresenter;

    public CreateNewClaimInteractor(CreateNewClaimDataAccessInterface createNewClaimDataAccessInterface,
                                    CreateNewClaimOutputBoundary createNewClaimOutputBoundary) {
        this.createNewClaimDataAccessObject = createNewClaimDataAccessInterface;
//        this.createNewClaimPresenter = createNewClaimOutputBoundary;
    }
    @Override
    public void execute() {
        /**
         * This method must:
         * - Take in a user object
         * - create a new Claim object
         * - call on the User's Add Claim method to add in said new claim object
         */

    }
}
