package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, Integer> {
    Optional<Client> findClientById(int clientId);
}
