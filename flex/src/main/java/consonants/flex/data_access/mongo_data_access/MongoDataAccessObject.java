package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Client;
import consonants.flex.entity.Claim;
import consonants.flex.entity.Form;
import consonants.flex.entity.LCInfoRequest;
import consonants.flex.use_case.view_all_claims.ViewAllClaimsDataAccessInterface;
import consonants.flex.use_case.login.LoginClientDataAccessInterface;
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
public class MongoDataAccessObject implements ViewAllClaimsDataAccessInterface, LoginClientDataAccessInterface {

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


    public Client createClient(String firstName, String lastName) {
        int clientId = 10000 + allClients().size() + 1;
        Client client = clientRepository.insert(new Client(clientId, firstName, lastName));
        return client;
    }

    public Claim createClaim(int clientId) {
        int claimId = 1000 + allClaims().size() + 1;
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

    public Form createForm(int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned) {
        int formId = allForms().size() + 1;
        Form form = formRepository.insert(new Form(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned));

        mongoTemplate.update(Claim.class)
                .matching(Criteria.where("claimId").is(claimId))
                .apply(new Update().push("forms").value(formId))
                .first();

        return form;
    }

    public Form createLCInfoRequestForm(int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned, String dateOfBirth, boolean completedDeathCertificate, boolean attachedDeathCertificate, boolean completedClaimSubmission, String causeOfDeath, boolean deceasedHospitalized, String hospitalName, String hospitalAddress, String attendingPhysicianName, String attendingPhysicianAddress, String attendingPhysicianContactNumber, ArrayList<String> pastPhysicianNames, ArrayList<String> pastPhysicianAddresses, String familyPhysicianName, String familyPhysicianAddress, String familyPhysicianContactNumber, String occupation, String employer, String dateLastWorked, String workAddress, String employerContactNumber, String reasonInsuredStoppedWorking, String nameOfKin, String kinAddress, String relationshipToInsured, String kinContactNumber, String kinSignature) {
        int formId = allForms().size() + 1;
        Form form = formRepository.insert(new LCInfoRequest(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned, dateOfBirth, completedDeathCertificate, attachedDeathCertificate, completedClaimSubmission,causeOfDeath, deceasedHospitalized, hospitalName, hospitalAddress, attendingPhysicianName, attendingPhysicianAddress, attendingPhysicianContactNumber, pastPhysicianNames, pastPhysicianAddresses, familyPhysicianName, familyPhysicianAddress, familyPhysicianContactNumber, occupation, employer, dateLastWorked, workAddress, employerContactNumber, reasonInsuredStoppedWorking, nameOfKin, kinAddress, relationshipToInsured, kinContactNumber, kinSignature));

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

    public Boolean clientExistsById(int clientId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        List<Client> lst = mongoTemplate.find(query, Client.class);
        return !lst.isEmpty();
    }
}

