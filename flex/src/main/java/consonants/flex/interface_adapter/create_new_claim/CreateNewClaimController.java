package consonants.flex.interface_adapter.create_new_claim;

import consonants.flex.use_case.create_new_claim.CreateNewClaimInputBoundary;
import consonants.flex.use_case.create_new_claim.CreateNewClaimInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/information/claims")

public class CreateNewClaimController {
    CreateNewClaimInputBoundary createNewClaimInteractor;
    public CreateNewClaimController(CreateNewClaimInputBoundary createNewClaimInteractor){
        this.createNewClaimInteractor = createNewClaimInteractor;
    }

    @PostMapping
    public ResponseEntity<String> createClaim(@RequestBody Map<String, String> info) {

        int clientId = Integer.parseInt(info.get("clientId"));

        CreateNewClaimInputData createNewClaimInputData = new CreateNewClaimInputData(clientId);
        createNewClaimInteractor.execute(createNewClaimInputData);

        return new ResponseEntity<>("New Claim Created for " + info.get("firstName"), HttpStatus.CREATED);
    }

}
