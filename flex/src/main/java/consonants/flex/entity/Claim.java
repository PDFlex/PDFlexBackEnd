package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
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
    private ArrayList<Integer> forms;
    private int claimId;
    private int clientId;
    private claimStatus status; // "Submitted", "Complete" or "Incomplete" (Look into Enum)


    public Claim(int clientId, int claimId){
        this.forms = new ArrayList<Integer>();
        this.claimId = claimId;
        this.status = claimStatus.INCOMPLETE;
        this.clientId = clientId;
    }

    public int getClaimId() {
        return this.claimId;
    }

    public enum claimStatus {
        INCOMPLETE,
        SUBMITTED,
        COMPLETE
    }

    public String claimStatusToString(){
        return this.status.toString();
    }
    public String updateStatus(String newStatus){
        if (newStatus == "INCOMPLETE") {
            this.status = claimStatus.INCOMPLETE;
            return claimStatusToString();
        }
        else if (newStatus == "SUBMITTED") {
            this.status = claimStatus.COMPLETE;
            return claimStatusToString();
        }
        else if (newStatus == "COMPLETE") {
            this.status = claimStatus.COMPLETE;
            return claimStatusToString();
        }
        else {
            return "Status choice invalid.";
        }
    }



    // getStatus() and getForms() should be automatically added with the Getters and Setters
}
