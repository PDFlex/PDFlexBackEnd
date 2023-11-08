package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Client;
import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsDataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoDataAccessObject implements ViewAllClaimsDataAccessInterface {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private FormRepository formRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Client> allClients() {return clientRepository.findAll();}
    public List<Claim> allClaims() {return claimRepository.findAll();}
    public List<Form> allForms() {return formRepository.findAll();}

//    @Override
//    public boolean claimsExist() {
//        if (!allClaims().isEmpty()) {
//            return true;
//        }
//        return false;
//    }

    public Client createClient(int clientId, String firstName, String lastName) {
        Client client = clientRepository.insert(new Client(clientId, firstName, lastName));
        return client;
    }

    public Claim createClaim(ArrayList<Form> forms, int status, int clientId, int claimId) {
        Claim claim = claimRepository.insert(new Claim(forms, status, clientId, claimId));

        mongoTemplate.update(Client.class)
                .matching(Criteria.where("clientId").is(clientId))
                .apply(new Update().push("claimsList").value(claimId))
                .first();

        return claim;
    }

    public Form createForm(int formId, int claimId, int clientId) {
        Form form = formRepository.insert(new Form(formId, claimId, clientId));

        mongoTemplate.update(Claim.class)
                .matching(Criteria.where("claimId").is(claimId))
                .apply(new Update().push("forms").value(formId))
                .first();

        return form;
    }

    public Client findClient(int clientId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        Client client = (Client) mongoTemplate.find(query, Client.class);
        return client;
    }

    public Claim findClaim(int claimId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("claimId").is(claimId));
        Claim claim = (Claim) mongoTemplate.find(query, Claim.class);
        return claim;
    }

    public Form findForm(int formId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("formId").is(formId));
        Form form = (Form) mongoTemplate.find(query, Form.class);
        return form;
    }
}
