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
    private boolean confirmed;
    private boolean filledOut;
    private boolean inProgress;
    private int formId;
    private int claimId;
    private int clientId;


    public Form(int formId, int claimId, int clientId) {
        this.confirmed = false;
        this.filledOut = false;
        this.inProgress = true;
        this.formId = formId; // randomly generate & will need to check that formId doesn't already exist when implementing FormUseCase - discuss further
        this.claimId = claimId;
        this.clientId = clientId;
    }

    // Consider checkConfirmed(), checkFilledOut() and checkInProgress() to be
    // the getters of their corresponding attributes
}
