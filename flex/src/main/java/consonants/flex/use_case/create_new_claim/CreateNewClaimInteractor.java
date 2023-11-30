package consonants.flex.use_case.create_new_claim;

import consonants.flex.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateNewClaimInteractor implements CreateNewClaimInputBoundary{
    @Autowired
    final CreateNewClaimDataAccessInterface createNewClaimDataAccessObject;

    public CreateNewClaimInteractor(CreateNewClaimDataAccessInterface createNewClaimDataAccessInterface) {
        this.createNewClaimDataAccessObject = createNewClaimDataAccessInterface;
    }
    @Override
    public CreateNewClaimOutputData execute(CreateNewClaimInputData createNewClaimInputData) {
        /*
         * This method calls on the Data Access Object to create a claim for the provided clientId
         * Returns the generated claim id.
         *
         **/
        Claim claim = createNewClaimDataAccessObject.createClaim(createNewClaimInputData.clientId);
        return new CreateNewClaimOutputData(claim.getClaimId());
    }
}