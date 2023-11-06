package consonants.flex.data_access;

import consonants.flex.entity.Client;
import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
import java.util.List;


public class DataAccessObject implements CreateNewClaimDataAccessInterface {

    private ClientDataAccessInterface clientDataAccessObject;
    private ClaimDataAccessInterface claimDataAccessObject;
    private FormDataAccessInterface formDataAccessObject;

    public List<Client> allClients() {return clientDataAccessObject.findAll();}
    public List<Claim> allClaims() {return claimDataAccessObject.findAll();}
    public List<Form> allForms() {return formDataAccessObject.findAll();}

    @Override
    public boolean claimsExist() {
        if (!allClaims().isEmpty()) {
            return true;
        }
        return false;
    }
}
