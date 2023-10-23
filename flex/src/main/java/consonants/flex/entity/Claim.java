package consonants.flex.entity;

import java.util.ArrayList;

public abstract class Claim {

    private ArrayList<Form> forms;
    private final int claimId;
    private String status; // "Submitted", "Complete" or "Incomplete" (Maybe look into Enum?)


    Claim(ArrayList<Form> forms, int claimId, String status){
        this.forms = forms;
        this.claimId = claimId;
        this.status = status;
    }

    public String updateStatus(String status){
        // TODO
        return null;
    }

    // getStatus() and getForms() should be automatically added with the Getters and Setters
}
