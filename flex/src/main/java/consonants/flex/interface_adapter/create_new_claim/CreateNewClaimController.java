package consonants.flex.interface_adapter.create_new_claim;

import consonants.flex.use_case.create_new_claim.CreateNewClaimInputBoundary;
import consonants.flex.use_case.create_new_claim.CreateNewClaimInputData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/new-claim")

public class CreateNewClaimController {
    CreateNewClaimInputBoundary createNewClaimInteractor;
    public CreateNewClaimController(CreateNewClaimInputBoundary createNewClaimInteractor){
        this.createNewClaimInteractor = createNewClaimInteractor;
    }

    @PostMapping
    public ResponseEntity<Integer> createClaim(@RequestBody Map<String, String> info) {

        int clientId = Integer.parseInt(info.get("clientId"));

        CreateNewClaimInputData createNewClaimInputData = new CreateNewClaimInputData(clientId);
        Integer claimId = createNewClaimInteractor.execute(createNewClaimInputData).getClaimId();

        return new ResponseEntity<>(claimId, HttpStatus.CREATED);
    }

}