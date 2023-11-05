package consonants.flex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document(collection = "claims")
@Data
@AllArgsConstructor
public abstract class Claim {

    private ArrayList<Form> forms;
    private final int claimId;
    private final int clientId;
    private String status; // "Submitted", "Complete" or "Incomplete" (Maybe look into Enum?)


    public Claim(ArrayList<Form> forms, String status, int clientId, int claimId){
        this.forms = forms;
        this.claimId = claimId; // randomly generate & will need to check that claimId doesn't already exist when implementing CreateNewClaimUseCase - discuss further
        this.status = status;
        this.clientId = clientId;
    }

    public String updateStatus(String status){
        // TODO
        return null;
    }

    // getStatus() and getForms() should be automatically added with the Getters and Setters
}
