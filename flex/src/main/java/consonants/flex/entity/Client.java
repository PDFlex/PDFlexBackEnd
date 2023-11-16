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
    private ArrayList<Object> claimsList;
    private int clientId;
    private String firstName;
    private String lastName;

    public Client(int clientId, String firstName, String lastName){
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.claimsList = new ArrayList<Object>();
    }

    // @ Override? (See CA CommonUser.java)
    public ArrayList<Object> getClaims(){return claimsList;}

    public Claim getClaim(int claimId){
        // TODO
        return null;
    }

    public void deleteClaim(int claimId){
        // Reconsider the return type. Return the claim that was deleted? Return a String with "sucesss" or "failure?"
        // TODO
    }



}
