package consonants.flex.use_case.view_claims_dashboard;

import consonants.flex.entity.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ViewClaimsDashboardInteractor implements ViewClaimsDashboardInputBoundary{
    @Autowired
    private final ViewClaimsDashboardDataAccessInterface claimDataAccessObject;

    @Autowired
    private final ViewClaimsDashboardOutputBoundary viewClaimsDashboardPresenter;

    public ViewClaimsDashboardInteractor(ViewClaimsDashboardDataAccessInterface claimDataAccessObject, ViewClaimsDashboardOutputBoundary viewClaimsDashboardPresenter) {
        this.claimDataAccessObject = claimDataAccessObject;
        this.viewClaimsDashboardPresenter = viewClaimsDashboardPresenter;
    }

    /**
     * Accesses DAO to first generate list of integers containing claimIds from Client object.
     * Accesses DAO again to generate a list of claim objects after retrieving the claimsList from Client object.
     * @param inputData is sent from the controller. An object that stores the clientId for the use case.
     * @return Response that includes a List of Claim objects belonging to the Client. Returns empty list if client
     * does not exist or if client has no claims. This controller should only be called after login (i.e. Client exists)
     */
    @Override
    public ResponseEntity<List<Claim>> execute(ViewClaimsDashboardInputData inputData) {
        int clientId = inputData.getClientId();
        List<Integer> claimIds = claimDataAccessObject.getClientClaimIds(clientId);
        List<Claim> claims = claimDataAccessObject.getClientClaimsListAsClaims(claimIds);
        ViewClaimsDashboardOutputData outputData = new ViewClaimsDashboardOutputData(claims);
        return new ResponseEntity<>(viewClaimsDashboardPresenter.viewClaims(outputData), HttpStatus.OK);
    }
}
