package consonants.flex.use_case.submit_claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmitClaimInteractor implements SubmitClaimInputBoundary {

    @Autowired
    final SubmitClaimDataAccessInterface claimDataAccessObject;

    @Autowired
    final SubmitClaimOutputBoundary submitClaimPresenter;

    public SubmitClaimInteractor(SubmitClaimDataAccessInterface claimDataAccessObject, SubmitClaimOutputBoundary submitClaimPresenter) {
        this.claimDataAccessObject = claimDataAccessObject;
        this.submitClaimPresenter = submitClaimPresenter;
    }

    @Override
    public ResponseEntity<Boolean> execute(SubmitClaimInputData inputData) {
        Boolean submitted = claimDataAccessObject.submitClaim(inputData.getClientId(), inputData.getClaimId());
        SubmitClaimOutputData outputData = new SubmitClaimOutputData(submitted);
        return new ResponseEntity<Boolean>(submitClaimPresenter.viewSubmitted(outputData), HttpStatus.OK);
    }
}
