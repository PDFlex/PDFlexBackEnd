package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Document(collection = "forms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    @Id
    private ObjectId id;
    private formStatus status;
    private int formId;
    private int clientId;
    // fields in common across all three forms
    private int claimId;
    private String deceasedName;
    private String dateOfDeath;
    private String dateSigned;
    private String createdFormDate;




    public Form(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned) {
        this.status = formStatus.IN_PROGRESS;
        this.formId = formId; // automatically created and passed to constructor in createForm method in DAO
        this.claimId = claimId;
        this.clientId = clientId;
        this.deceasedName = deceasedName;
        this.dateOfDeath = dateOfDeath;
        this.dateSigned = dateSigned;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.createdFormDate = LocalDate.now().format(formatter);
    }

    public int getFormId() {
        return this.formId;
    }

    public enum formStatus {
        CONFIRMED,
        FILLED_OUT,
        IN_PROGRESS
    }

    public String formStatusToString(){
        return this.status.toString();
    }

    /**
     * @param newStatus
     * @return Returns a string indicating the new status of the form or if the status choice was invalid.
     */
    public String updateStatus(String newStatus){
        if (newStatus == "IN_PROGRESS") {
            this.status = formStatus.IN_PROGRESS;
            return formStatusToString();
        }
        else if (newStatus == "FILLED_OUT") {
            this.status = formStatus.FILLED_OUT;
            return formStatusToString();
        }
        else if (newStatus == "CONFIRMED") {
            this.status = formStatus.CONFIRMED;
            return formStatusToString();
        }
        else {
            return "Status choice invalid.";
        }
    }
}
