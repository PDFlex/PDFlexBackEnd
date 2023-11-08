package consonants.flex.use_case.view_all_claims;

import consonants.flex.entity.Claim;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViewAllClaimsInputBoundary {
    ResponseEntity<List<Claim>> execute();
}
