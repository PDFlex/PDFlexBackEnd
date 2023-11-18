package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private ObjectId id;
    private ArrayList<Claim> claimsList;
    private int clientId;
    private String firstName;
    private String lastName;

    public Client(int clientId, String firstName, String lastName){
        this.clientId = clientId; // randomly created in createClaim method in DAO
        this.firstName = firstName;
        this.lastName = lastName;
        this.claimsList = new ArrayList<Claim>();
    }

    public int getClientId(){
        return this.clientId;
    }
    public ArrayList<Claim> getClaims(){return claimsList;}

    public boolean deleteClaimFromClient(int claimId){
        for (Claim claim : this.claimsList) {
            if (claim.getClaimId() == claimId) {
                this.claimsList.remove(claim);
                return true;
            }
        }
        return false;
    }



}
