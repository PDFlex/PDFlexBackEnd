package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Form;
import consonants.flex.entity.LCInfoRequest;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormRepository extends MongoRepository<Form, ObjectId> {
    Form findFormByFormId(int formId);
    LCInfoRequest findLCFormByFormId(int formId);
}
