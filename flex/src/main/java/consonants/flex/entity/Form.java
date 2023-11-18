package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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




    public Form(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned) {
        this.status = formStatus.IN_PROGRESS;
        this.formId = formId; // automatically created and passed to constructor in createForm method in DAO
        this.claimId = claimId;
        this.clientId = clientId;
        this.deceasedName = deceasedName;
        this.dateOfDeath = dateOfDeath;
        this.dateSigned = dateSigned;
    }

    public int getFormId() {
        return this.formId;
    }

    public enum formStatus {
        CONFIRMED,
        FILLED_OUT,
        IN_PROGRESS
    }
    // Consider checkConfirmed(), checkFilledOut() and checkInProgress() to be
    // the getters of their corresponding attributes.
}
