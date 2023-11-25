package consonants.flex.data_access.mongo_data_access;
import consonants.flex.entity.FileDocument;
import consonants.flex.entity.Form;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends MongoRepository<FileDocument, String>{
    // implement custom query
    Optional<FileDocument> findFileDocumentByClaimId(int claimId);
    // findByStatusIncludeItemAndStatusFields
}