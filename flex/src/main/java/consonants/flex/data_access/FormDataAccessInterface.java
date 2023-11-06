package consonants.flex.data_access;

import consonants.flex.entity.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormDataAccessInterface extends MongoRepository<Form, Integer> {
}
