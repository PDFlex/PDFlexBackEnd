package consonants.flex.use_case.view_claims_dashboard;

import consonants.flex.entity.Claim;

import java.util.List;
import java.util.Optional;

public interface ViewClaimsDashboardDataAccessInterface {

    /**
     * @param clientId the id of the Client.
     * @return List of Integers corresponding to claimIds for Claims belonging to the Client ; Empty otherwise.
     */
    List<Integer> getClientClaimIds(int clientId);


    /**
     * @param claimIds The integers from the Client's claimList.
     * @return List of Claim objects corresponding to claimIds for Claims belonging to the Client ; Empty otherwise.
     */
    List<Claim> getClientClaimsListAsClaims(List<Integer> claimIds);
}
