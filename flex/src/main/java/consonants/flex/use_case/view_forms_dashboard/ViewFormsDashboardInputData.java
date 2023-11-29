package consonants.flex.use_case.view_forms_dashboard;

public class ViewFormsDashboardInputData {
    final private int clientId;
    final private int claimId;

    public ViewFormsDashboardInputData(int clientId, int claimId) {
        this.clientId = clientId;
        this.claimId = claimId;
    }

    int getClientId() {return this.clientId;}
    int getClaimId() {return this.claimId;}
}
