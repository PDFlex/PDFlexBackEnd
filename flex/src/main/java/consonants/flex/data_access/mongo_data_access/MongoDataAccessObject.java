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
import java.util.Optional;

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

    public Optional<Client> findClient(int clientId) {
//        The below commented out method body works. It may be a better way to deal with null returns. i.e. when lst is empty.
//        Query query = new Query();
//        query.addCriteria(Criteria.where("clientId").is(clientId));
//        List<Client> lst = mongoTemplate.find(query, Client.class);
//        return lst.get(0);
        Optional<Client> client = clientRepository.findClientByClientId(clientId);
        return client;
    }

    public Optional<Claim> findClaim(int claimId) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("claimId").is(claimId));
//        Claim claim = (Claim) mongoTemplate.find(query, Claim.class);
        Optional<Claim> claim = claimRepository.findClaimByClaimId(claimId);
        return claim;
    }

    public Optional<Form> findForm(int formId) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("formId").is(formId));
//        Form form = (Form) mongoTemplate.find(query, Form.class);
        Optional<Form> form = formRepository.findFormByFormId(formId);
        return form;
    }

    public boolean loginClientExists(int clientId, String firstName, String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        query.addCriteria(Criteria.where("firstName").is(firstName));
        query.addCriteria(Criteria.where("lastName").is(lastName));
        List<Client> lst = mongoTemplate.find(query, Client.class);

        if (!lst.isEmpty()) {
            return true;
        }
        return false;
    }
}
