package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private ObjectId id;
    private List<Integer> claimsList;
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


    public List<Integer> getClaims() {return claimsList;}


    /**
     * @param claimId
     * @return returns true if removal of claim with claimId was successful; false otherwise.
     */
    public boolean removeClaimFromClient(int claimId){
        for (int claimNumber : this.claimsList) {
            if (claimNumber == claimId) {
                this.claimsList.remove(claimNumber);
                return true;
            }
        }
        return false;
    }



}
