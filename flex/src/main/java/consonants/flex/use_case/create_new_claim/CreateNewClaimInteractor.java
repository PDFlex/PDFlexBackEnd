package consonants.flex.use_case.create_new_claim;

import consonants.flex.entity.*;

import java.util.ArrayList;

public class CreateNewClaimInteractor implements CreateNewClaimInputBoundary{
    final CreateNewClaimDataAccessInterface createNewClaimDataAccessObject;
//    final CreateNewClaimOutputBoundary CreateNewClaimPresenter;

    public CreateNewClaimInteractor(CreateNewClaimDataAccessInterface createNewClaimDataAccessInterface,
                                    CreateNewClaimOutputBoundary createNewClaimOutputBoundary) {
        this.createNewClaimDataAccessObject = createNewClaimDataAccessInterface;
//        this.createNewClaimPresenter = createNewClaimOutputBoundary;
    }
    @Override
    public void execute(CreateNewClaimInputData client) {
        /**
         * This method must:
         * - Take in a user object
         * - create a new Claim object
         * - call on the User's Add Claim method to add in said new claim object
         * Instantiates a LifeClaim and associates it with the Client.
         * Generates a new Claim ID for it
         * for right now, we can just start at 1 and increment up for each subsequent Claim ID in the system
         * Gives the LifeClaim the default status “Not completed”
         * Status ‘dictionary’ to be changed later since we’re assigning integer values to statuses (as per discussion by ben, Vithu, Jiya)
         * Instantiates a LCInfoRequest and associates it with the LifeClaim and Client.
         * Generates new Form ID for it (follow same procedure as Claim ID)
         * Empty ‘form fields’ attributes
         * Persists this Claim in the database
         */
        // Initialize Forms Objects
        LCInfoRequest lcInfoRequest = new LCInfoRequest(false, false, true);
        LCInitiation lcInitiation = new LCInitiation(false, false, true);
        PhysicianStatement physicianStatement = new PhysicianStatement(false, false, true);
        ArrayList<Form> forms = new ArrayList<>();
        forms.add(lcInfoRequest);
        forms.add(lcInitiation);
        forms.add(physicianStatement);


        //TODO: Function that generates new claim id, tracking prior ones
        int claimId = 1;
        // TODO: use enum for statuses
        int status = 0;
        int clientId = 1;

        // Initialize Claim Object
        LifeClaim lifeClaim = new LifeClaim(forms, status, clientId, claimId);

        // Update Client's Claims attribute with new claim object
        client.client.addClaim(lifeClaim);

        // Need to update the client's data in the Database

        // Need to update presenter


    }
}
