package consonants.flex.entity;

import org.bson.types.ObjectId;

public class PhysicianStatement extends Form{
    public PhysicianStatement(int formId, int claimId, int clientId) {
        super(formId, claimId, clientId);
    }
}
