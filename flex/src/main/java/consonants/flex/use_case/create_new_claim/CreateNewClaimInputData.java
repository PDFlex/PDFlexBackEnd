package consonants.flex.use_case.create_new_claim;

import consonants.flex.entity.Client;

public class CreateNewClaimInputData {
    /**
     * This simply stores the client object for the UCI to access.
     */
    final Client client;
    public CreateNewClaimInputData(Client client) {
        this.client = client;
    }
}
