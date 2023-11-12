package consonants.flex.interface_adapter.get_user_info;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Client;
import consonants.flex.use_case.get_user_info.GetUserInfoInputBoundary;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/claims")
public class GetUserInfoController {
    @Autowired
    private GetUserInfoInputBoundary getUserInfoInteractor;

    @GetMapping("/{accountId}")

    public ResponseEntity<Client> getAllClaims(int accountId) {
        return getUserInfoInteractor.execute(accountId);
    }





}



