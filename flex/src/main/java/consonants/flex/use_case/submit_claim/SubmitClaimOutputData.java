package consonants.flex.use_case.submit_claim;

public class SubmitClaimOutputData {
    private final Boolean submitted;

    public SubmitClaimOutputData(Boolean submitted) {
        this.submitted = submitted;
    }

    public Boolean getSubmittedValue() {
        return this.submitted;
    }
}
