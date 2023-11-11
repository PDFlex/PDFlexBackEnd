package consonants.flex.use_case.get_user_info;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Client;
import consonants.flex.entity.Form;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public interface GetUserInfoDataAccessInterface {

    public Claim findClaim(int claimId);

    public Client findClient(int accountId);
}
