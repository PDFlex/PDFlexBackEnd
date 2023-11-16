package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document(collection = "claims")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @Id
    private ObjectId id; // mongoDB uses a variable of type ObjectId for the fields
    private ArrayList<Form> forms;
    @Getter private int claimId;
    private int clientId;
    @Getter private int status; // "Submitted", "Complete" or "Incomplete" (Look into Enum)


    public Claim(int clientId, int claimId){
        this.forms = new ArrayList<Form>();
        this.claimId = claimId; // randomly generate & will need to check that claimId doesn't already exist when implementing CreateNewClaimUseCase - discuss further
        this.status = 0;
        this.clientId = clientId;
    }

    public enum ClaimStatus {
        SUBMITTED,
        COMPLETE,
        INCOMPLETE;
    }

    public String updateStatus(String status){
        // TODO
        return null;
    }

    // getStatus() and getForms() should be automatically added with the Getters and Setters
}
