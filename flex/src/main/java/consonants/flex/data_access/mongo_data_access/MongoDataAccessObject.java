package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Client;
import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.entity.LCInfoRequest;
import consonants.flex.use_case.edit_form.EditFormDataAccessInterface;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsDataAccessInterface;
import consonants.flex.use_case.login.LoginClientDataAccessInterface;
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
public class MongoDataAccessObject implements ViewAllClaimsDataAccessInterface, LoginClientDataAccessInterface {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private FormRepository formRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * For our purposes, this method will not be used because we do not have a SignupUseCase,
     * thus plan to hardcode Clients into our DB.
     * Creates a new Client in the MongoDB. Automatically creates its clientId based on
     * the number of Clients that already exist in the MongoDB.
     * @param firstName The first name of the client.
     * @param lastName The last name of the client.
     * @return The Client object whose data corresponds to its data in the MongoDB.
     */
    public Client createClient(String firstName, String lastName) {
        int clientId = 10000 + getAllClients().size() + 1;
        return clientRepository.insert(new Client(clientId, firstName, lastName));
    }

    /**
     * Creates a new Claim in our MongoDB. Automatically creates its claimId based on
     * the number of Claims that already exist in the MongoDB.
     * @param clientId The clientId of the Client that this Claim is associated with.
     * @return The Claim object whose data corresponds to its data in the MongoDB.
     */
    public Claim createClaim(int clientId) {
        int claimId = 1000 + getAllClaims().size() + 1;
        Claim claim = claimRepository.insert(new Claim(clientId, claimId));

        ArrayList<String> pastPhysicianNames = new ArrayList<String>();
        ArrayList<String> pastAddresses = new ArrayList<String>();
        Form form = createLCInfoRequestForm(claimId, clientId, "", "", "", "", false, false, false, "", false, "", "", "", "", "", pastPhysicianNames, pastAddresses, "", "", "","","","","","","","","","","","");

        mongoTemplate.update(Client.class)
                .matching(Criteria.where("clientId").is(clientId))
                .apply(new Update().push("claimsList").value(claimId))
                .first();

        return claim;
    }

    /**
     * Creates a new Form (of type Life Claim Information Request) in our MongoDB.
     * Automatically creates its formId based on the number of Forms that already exist in the MongoDB.
     * Parameter comments omitted due to length.
     * @return The Form object with the specified data.
     */
    public Form createLCInfoRequestForm(int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned, String dateOfBirth, boolean completedDeathCertificate, boolean attachedDeathCertificate, boolean completedClaimSubmission, String causeOfDeath, boolean deceasedHospitalized, String hospitalName, String hospitalAddress, String attendingPhysicianName, String attendingPhysicianAddress, String attendingPhysicianContactNumber, ArrayList<String> pastPhysicianNames, ArrayList<String> pastPhysicianAddresses, String familyPhysicianName, String familyPhysicianAddress, String familyPhysicianContactNumber, String occupation, String employer, String dateLastWorked, String workAddress, String employerContactNumber, String reasonInsuredStoppedWorking, String nameOfKin, String kinAddress, String relationshipToInsured, String kinContactNumber, String kinSignature) {
        int formId = getAllForms().size() + 1;
        Form form = formRepository.insert(new LCInfoRequest(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned, dateOfBirth, completedDeathCertificate, attachedDeathCertificate, completedClaimSubmission,causeOfDeath, deceasedHospitalized, hospitalName, hospitalAddress, attendingPhysicianName, attendingPhysicianAddress, attendingPhysicianContactNumber, pastPhysicianNames, pastPhysicianAddresses, familyPhysicianName, familyPhysicianAddress, familyPhysicianContactNumber, occupation, employer, dateLastWorked, workAddress, employerContactNumber, reasonInsuredStoppedWorking, nameOfKin, kinAddress, relationshipToInsured, kinContactNumber, kinSignature));

        mongoTemplate.update(Claim.class)
                .matching(Criteria.where("claimId").is(claimId))
                .apply(new Update().push("forms").value(formId))
                .first();

        return form;
    }

    /**
     * Can use this template to create methods to modify a specific field in client object
     * for example, field = "firstName", will update the firstName attribute of the Client
     * findAndModify returns a Client Object; can change the return to void, boolean, etc, as needed.
     * @return The Client with modified fields.
     */
    public Client modifyClient(int clientId, String field, Object newEntry) {

        Query query = new Query().addCriteria(Criteria.where("clientId").is(clientId));
        Update updateDefinition = new Update().set(field, newEntry);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);

        return mongoTemplate.findAndModify(query, updateDefinition, Client.class);
    }

    /**
     * Like previous method, this finds a Client using a criteria. This method is pre-set
     * to the firstName field. Returns a Client Object. Can change return type if needed.
     * @return The Client with modified fields.
     */
    public Client modifyClientFirstName(int clientId, String newFirstName) {
        Query query = new Query().addCriteria(Criteria.where("clientId").is(clientId));
        Update updateDefinition = new Update().set("firstName", newFirstName);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);

        return mongoTemplate.findAndModify(query, updateDefinition, options, Client.class);
    }

    /**
     * @return A List of all the Clients in the MongoDB.
     */
    public List<Client> getAllClients() {return clientRepository.findAll();}

    /**
     * @return A List of all the Claims in the MongoDB.
     */
    public List<Claim> getAllClaims() {return claimRepository.findAll();}

    /**
     * @return A List of all the Forms in the MongoDB.
     */
    public List<Form> getAllForms() {return formRepository.findAll();}

    /**
     * Retrieves the Client from the MongoDB with the corresponding unique clientId.
     * @param clientId The clientId of the Client.
     * @return The Client with the clientId; null if it does not exist.
     */
    public Optional<Client> getClientById(int clientId) {
        return clientRepository.findClientByClientId(clientId);
    }

    /**
     * Retrieves the Claim from the MongoDB with the corresponding unique claimId.
     * @param claimId The claimId of the Claim.
     * @return The Claim with the claimId; null if it doesn't exist.
     */
    public Optional<Claim> getClaimById(int claimId) {
        return claimRepository.findClaimByClaimId(claimId);
    }

    /**
     * Gets the Form with the unique formId from the MongoDB.
     * This method works for the general 'Form' class; that is,
     * it retrieves any object in the 'pdflex-db > forms' collection in the MongoDB.
     * @param formId The formId of the Form.
     * @return The Form with the formId; null if it doesn't exist.
     */
    public Optional<Form> getFormById(int formId) {
        return formRepository.findFormByFormId(formId);
    }

    /**
     * Returns a List of all the Clients in the MongoDB whose first name starts with a certain letter.
     * @param letter The first letter of the Client's first name.
     * @return The List of Clients.
     */
    public List<Client> getClientsByFirstNameFirstLetter(String letter) {
        // can use this template to find clients by the first letter of their first names
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").regex(letter));
        List<Client> clients = mongoTemplate.find(query, Client.class);
        return clients;
    }

    /**
     * @return An alphabetically sorted (by first name) List of all Clients.
     */
    public List<Client> getClientsByFirstNameAlphabetically() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "firstName"));
        List<Client> clients = mongoTemplate.find(query, Client.class);
        return clients;
    }

    public Boolean clientExistsById(int clientId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        List<Client> lst = mongoTemplate.find(query, Client.class);
        return !lst.isEmpty();
    }
}

