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
    private ArrayList<Integer> claimsList;
    private int clientId;
    private String firstName;
    private String lastName;

    public Client(int clientId, String firstName, String lastName){
        this.clientId = clientId; // randomly created in createClaim method in DAO
        this.firstName = firstName;
        this.lastName = lastName;
        this.claimsList = new ArrayList<Integer>();
    }

    public int getClientId(){
        return this.clientId;
    }
    public ArrayList<Integer> getClaims(){return claimsList;}

    public boolean deleteClaimFromClient(int claimId){
        for (int claim : this.claimsList) {
            if (claim == claimId) {
                this.claimsList.remove(claim);
                return true;
            }
        }
        return false;
    }



}
