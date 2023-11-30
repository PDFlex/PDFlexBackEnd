package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Claim;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends MongoRepository<Claim, ObjectId> {
    Claim findClaimByClaimId(int claimId);
}
