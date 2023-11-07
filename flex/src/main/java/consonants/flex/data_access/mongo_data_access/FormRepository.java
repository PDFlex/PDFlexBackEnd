package consonants.flex.data_access.mongo_data_access;

import consonants.flex.entity.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormRepository extends MongoRepository<Form, Integer> {
}
