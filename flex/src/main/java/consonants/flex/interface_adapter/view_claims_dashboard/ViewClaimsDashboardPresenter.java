package consonants.flex.interface_adapter.view_claims_dashboard;

import consonants.flex.entity.Claim;
import consonants.flex.use_case.view_claims_dashboard.ViewClaimsDashboardOutputBoundary;
import consonants.flex.use_case.view_claims_dashboard.ViewClaimsDashboardOutputData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewClaimsDashboardPresenter implements ViewClaimsDashboardOutputBoundary {
    @Override
    public List<Claim> viewClaims(ViewClaimsDashboardOutputData outputData) {return outputData.getClaims();}
}
