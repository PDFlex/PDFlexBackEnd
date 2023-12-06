package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "claims")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @Id
    private ObjectId id; // mongoDB uses a variable of type ObjectId for the fields
    private List<Integer> forms;
    private int claimId;
    private int clientId;
    private claimStatus status; // "Submitted", "Complete" or "Incomplete" (Look into Enum)
    private String createdClaimDate;


    public Claim(int clientId, int claimId){
        this.forms = new ArrayList<Integer>();
        this.claimId = claimId;
        this.status = claimStatus.INCOMPLETE;
        this.clientId = clientId;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.createdClaimDate = LocalDate.now().format(formatter);
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

    /**
     * @param newStatus
     * @return returns a String indicating the new status or if the choice of status is invalid.
     */
    public String updateStatus(String newStatus){
        if (newStatus == "INCOMPLETE") {
            this.status = claimStatus.INCOMPLETE;
            return claimStatusToString();
        }
        else if (newStatus == "SUBMITTED") {
            this.status = claimStatus.SUBMITTED;
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
