package consonants.flex.interface_adapter.view_all_claims;

import consonants.flex.entity.Claim;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsOutputBoundary;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsOutputData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewAllClaimsPresenter implements ViewAllClaimsOutputBoundary {
    // Note that this class doesn't actually function like the CACoding Presenter - all it does is implement the
    // OutputBoundary so that the interactor can actually return something to the Controller
    @Override
    public List<Claim> viewAllClaims(ViewAllClaimsOutputData outputData) {
        return outputData.getAllClaims();
    }
}
