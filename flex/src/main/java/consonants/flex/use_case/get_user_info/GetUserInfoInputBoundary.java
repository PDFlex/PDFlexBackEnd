package consonants.flex.use_case.get_user_info;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetUserInfoInputBoundary {
    ResponseEntity<Client> execute(int accountId);

}
