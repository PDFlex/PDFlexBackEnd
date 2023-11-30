package consonants.flex.interface_adapter.submit_claim;

import consonants.flex.use_case.submit_claim.SubmitClaimOutputBoundary;
import consonants.flex.use_case.submit_claim.SubmitClaimOutputData;
import org.springframework.stereotype.Service;

@Service
public class SubmitClaimPresenter implements SubmitClaimOutputBoundary {
    @Override
    public Boolean viewSubmitted(SubmitClaimOutputData outputData) {
        return outputData.getSubmittedValue();
    }
}
