package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimRepository extends MongoRepository<Claim, Integer> {

}
