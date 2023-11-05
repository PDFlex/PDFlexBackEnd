package consonants.flex.data_access;

import consonants.flex.entity.Client;
import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DataAccessObject implements CreateNewClaimDataAccessInterface {

    private DataAccessInterface clientDataAccessObject;

    public List<Client> allClients() {return clientDataAccessObject.findAll();}
}
