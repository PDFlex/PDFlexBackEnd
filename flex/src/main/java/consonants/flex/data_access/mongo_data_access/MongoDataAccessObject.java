package consonants.flex.data_access.mongo_data_access;

import com.mongodb.client.result.UpdateResult;
import consonants.flex.entity.Client;
import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsDataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
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
        // This creates new client object. Will need to convert this into a ClientFactory class to adhere to CA.
        Client client = clientRepository.insert(new Client(clientId, firstName, lastName));
        return client;
    }

    public Claim createClaim(int clientId, int claimId) {
        // This creates new Claim object. Will need to convert this creation into a ClaimFactory class to adhere to CA.
        // Updates corresponding Client's list of claims.
        Claim claim = claimRepository.insert(new Claim(clientId, claimId));

        mongoTemplate.update(Client.class)
                .matching(Criteria.where("clientId").is(clientId))
                .apply(new Update().push("claimsList").value(claimId))
                .first();

        return claim;
    }

    public Form createForm(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned) {
        // This creates new Form object. Will need to convert this creation into a FormFactory class to adhere to CA.
        // Updates corresponding Claim's list of forms. Potentially unnecessary method; revisit.
        Form form = formRepository.insert(new Form(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned));

        mongoTemplate.update(Claim.class)
                .matching(Criteria.where("claimId").is(claimId))
                .apply(new Update().push("forms").value(formId))
                .first();

        return form;
    }

    public Optional<Client> findClient(int clientId) {
        // returns a Client object such that Client.clientId = clientId
        Optional<Client> client = clientRepository.findClientByClientId(clientId);
        return client;
    }

    public List<Client> findClientsStartingWith(String letter) {
        // can use this template to find clients by the first letter of their first names
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").regex(letter));
        List<Client> clients = mongoTemplate.find(query, Client.class);
        return clients;
    }

    public Client modifyClient(int clientId, String field, Object newEntry) {
        // can use this template to create methods to modify a specific field in client object
        // for example, field = "firstName", will update the firstName attribute of the Client
        // findAndModify returns a Client Object; can change updateClient to return void, boolean, etc, as needed
        Query query = new Query().addCriteria(Criteria.where("clientId").is(clientId));
        Update updateDefinition = new Update().set(field, newEntry);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);

        return mongoTemplate.findAndModify(query, updateDefinition, Client.class);
    }

    public Client modifyFirstName(int clientId, String newFirstName) {
        // Like previous method, this finds a Client using a criteria. This method is pre-set
        // to the firstName field. Returns a Client Object.
        // can change return type of modifyFirstName as needed
        Query query = new Query().addCriteria(Criteria.where("clientId").is(clientId));
        Update updateDefinition = new Update().set("firstName", newFirstName);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);

        return mongoTemplate.findAndModify(query, updateDefinition, options, Client.class);
    }

    public List<Client> sortAllClientsByName() {
        // returned an alphabetically sorted list of all clients
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "firstName"));
        List<Client> clients = mongoTemplate.find(query, Client.class);
        return clients;
    }

    public Optional<Claim> findClaim(int claimId) {
        // returns a Claim object such that Claim.claimId = claimId
        Optional<Claim> claim = claimRepository.findClaimByClaimId(claimId);
        return claim;
    }

    public Optional<Form> findForm(int formId) {
        // returns a Form object such that Form.formId = formId
        Optional<Form> form = formRepository.findFormByFormId(formId);
        return form;
    }

    public boolean loginClientExists(int clientId) {
        // checks if a Client object with clientId is in the database
        // returns true if such a client exists, returns false otherwise
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        List<Client> lst = mongoTemplate.find(query, Client.class);

        if (!lst.isEmpty()) {
            return true;
        }
        return false;
    }
}
