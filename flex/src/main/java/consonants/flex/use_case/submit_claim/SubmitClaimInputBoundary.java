package consonants.flex.use_case.submit_claim;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SubmitClaimInputBoundary {
    ResponseEntity<Boolean> execute(SubmitClaimInputData inputData);
}
