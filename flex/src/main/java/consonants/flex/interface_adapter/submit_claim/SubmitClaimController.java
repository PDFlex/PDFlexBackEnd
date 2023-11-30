package consonants.flex.interface_adapter.submit_claim;

import consonants.flex.use_case.submit_claim.SubmitClaimInputBoundary;
import consonants.flex.use_case.submit_claim.SubmitClaimInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{clientId}/{claimId}")
public class SubmitClaimController {
    @Autowired
    private SubmitClaimInputBoundary submitClaimInteractor;

    @GetMapping("/submit")
    public ResponseEntity<Boolean> submitClaim(@PathVariable int clientId, @PathVariable int claimId) {
        SubmitClaimInputData inputData = new SubmitClaimInputData(clientId, claimId);
        return submitClaimInteractor.execute(inputData);
    }
}
