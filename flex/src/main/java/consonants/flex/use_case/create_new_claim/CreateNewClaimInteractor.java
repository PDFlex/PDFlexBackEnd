package consonants.flex.use_case.create_new_claim;

//import consonants.flex.entity.*;

import consonants.flex.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

@RestController
public class CreateNewClaimInteractor implements CreateNewClaimInputBoundary{
    @Autowired
    final CreateNewClaimDataAccessInterface createNewClaimDataAccessObject;
    final CreateNewClaimOutputBoundary createNewClaimOutputBoundary;

    public CreateNewClaimInteractor(CreateNewClaimDataAccessInterface createNewClaimDataAccessInterface, CreateNewClaimOutputBoundary createNewClaimOutputBoundary) {
        this.createNewClaimDataAccessObject = createNewClaimDataAccessInterface;
        this.createNewClaimOutputBoundary = createNewClaimOutputBoundary;
    }
    @Override
    public CreateNewClaimOutputData execute(CreateNewClaimInputData createNewClaimInputData) {
        /*
         * This method must:
         * - Take in a user id
         * - Create a new (empty, marked incomplete) claim in the database
         * - Return the New Claim's Id
         *
         **/
        // Initialize Forms List to be empty
        ArrayList<Form> forms = new ArrayList<>();


        // Need to update the client's data in the Database
        Claim claim = createNewClaimDataAccessObject.createClaim(forms, status, createNewClaimInputData.clientId, claimId);
        return new CreateNewClaimOutputData(claim.getClaimId());
    }
}
