package consonants.flex.use_case.create_new_claim;

public class CreateNewClaimInputData {
    /**
     * This simply stores the client object for the UCI to access.
     */
    final int clientId;
    public CreateNewClaimInputData(int clientId) {
        this.clientId = clientId;
    }
}