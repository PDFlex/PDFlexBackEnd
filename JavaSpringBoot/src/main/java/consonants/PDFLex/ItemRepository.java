package consonants.PDFLex;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, ObjectId> {
    // ignore this comment
    Optional<Item> findItemByFirstName(String firstName);
}
