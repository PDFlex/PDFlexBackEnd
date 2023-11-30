package consonants.flex.use_case.submit_claim;

public class SubmitClaimInputData {
    final private int clientId;
    final private int claimId;

    public SubmitClaimInputData(int clientId, int claimId) {
        this.clientId = clientId;
        this.claimId = claimId;
    }

    int getClientId() {
        return this.clientId;
    }

    int getClaimId() {
        return this.claimId;
    }
}
