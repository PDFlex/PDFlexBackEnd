package consonants.flex.entity;

import org.bson.types.ObjectId;

public class LCInfoRequest extends Form {
    public LCInfoRequest(int formId, int claimId, int clientId) {
        super(formId, claimId, clientId);
    }
}
