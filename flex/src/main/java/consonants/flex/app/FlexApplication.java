package consonants.flex.app;

import consonants.flex.data_access.mongo_data_access.ClientRepository;
import consonants.flex.entity.Client;
import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlexApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexApplication.class, args);
	}

}
