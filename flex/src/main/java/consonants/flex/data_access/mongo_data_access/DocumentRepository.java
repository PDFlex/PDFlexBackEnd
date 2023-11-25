package consonants.flex.data_access.mongo_data_access;
import consonants.flex.entity.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DocumentRepository extends MongoRepository<FileDocument, String>{
    // implement custom query
}