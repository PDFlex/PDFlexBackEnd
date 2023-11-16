package consonants.flex.data_access;

import consonants.flex.entity.Client;
import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.List;


public class DataAccessObject implements CreateNewClaimDataAccessInterface {

    private ClientDataAccessInterface clientDataAccessObject;
    private ClaimDataAccessInterface claimDataAccessObject;
    private FormDataAccessInterface formDataAccessObject;
    private MongoTemplate mongoTemplate;

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


    public Client createClient(int clientId, String firstName, String lastName) {
        ArrayList<Claim> claimsList = new ArrayList<Claim>();
        Client client = clientDataAccessObject.insert(new Client(claimsList, clientId, firstName, lastName));
        return client;
    }

    public Claim createClaim(ArrayList<Form> forms, int status, int clientId, int claimId) {
        Claim claim = claimDataAccessObject.insert(new Claim(forms, status, clientId, claimId));

        mongoTemplate.update(Client.class)
                .matching(Criteria.where("clientId").is(clientId))
                .apply(new Update().push("claimsList").value(claim))
                .first();

        return claim;
    }

    @Override
    public Client findClient(int clientId) {
        return null;
    }

    public Form createForm(int formId, int claimId, int clientId) {
        Form form = formDataAccessObject.insert(new Form(formId, claimId, clientId));

        mongoTemplate.update(Claim.class)
                .matching(Criteria.where("claimId").is(claimId))
                .apply(new Update().push("forms").value(form))
                .first();

        return form;
    }
}
