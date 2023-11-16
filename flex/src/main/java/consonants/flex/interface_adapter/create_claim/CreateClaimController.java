package consonants.flex.interface_adapter.create_claim;
import consonants.flex.data_access.mongo_data_access.MongoDataAccessObject;
import consonants.flex.entity.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/claims")
public class CreateClaimController {
    @Autowired
    private MongoDataAccessObject claimRepository;

    @PostMapping("/new")
    public ResponseEntity<Claim> createNewClaim(@RequestBody Map<String, Integer> payload) {
        return new ResponseEntity<Claim>(claimRepository.createClaim(payload.get("clientId"), payload.get("claimId")), HttpStatus.CREATED);
    }
}
