package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, ObjectId> {
    Optional<Client> findClientById(int clientId);

}
