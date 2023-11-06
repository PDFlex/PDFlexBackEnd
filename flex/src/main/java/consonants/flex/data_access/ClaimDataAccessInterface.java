package consonants.flex.data_access;

import consonants.flex.entity.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimDataAccessInterface extends MongoRepository<Claim, Integer> {

}
