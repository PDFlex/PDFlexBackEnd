package consonants.flex.data_access.mongo_data_access;
import consonants.flex.entity.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface DocumentRepository extends MongoRepository<FileDocument, String>{
    // implement custom query
//     FileDocument save(FileDocument fileDocument);
}