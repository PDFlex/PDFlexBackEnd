package consonants.flex.entity;

import org.bson.types.ObjectId;

public class LCInitiation extends Form {
    public LCInitiation(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned) {
        super(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned);
    }
}
