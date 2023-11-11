package consonants.flex.use_case.get_user_info;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Client;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsOutputData;

import java.util.List;

public interface GetUserInfoOutputBoundary {
    // Want to return client and claims list
    Client getUserInfo(GetUserInfoOutputData outputData);
}
