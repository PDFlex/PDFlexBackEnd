package consonants.flex.use_case.get_user_info;

import consonants.flex.entity.Claim;
import consonants.flex.entity.Client;

import java.util.List;

public class GetUserInfoOutputData {
    private Client client;
    private List<Claim> claims;

    public GetUserInfoOutputData(Client client, List<Claim> claims) {this.client = client; this.claims = claims;}

    public List<Claim> getUserClaims() {return claims;}
    public Client getClient() {return client;}

}
