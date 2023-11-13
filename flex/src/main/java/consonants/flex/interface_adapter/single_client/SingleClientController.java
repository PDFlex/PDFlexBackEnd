/**
 * Unused Controller
 */

package consonants.flex.interface_adapter.single_client;

import consonants.flex.data_access.mongo_data_access.MongoDataAccessObject;
import consonants.flex.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/test")
public class SingleClientController {
    @Autowired
    private MongoDataAccessObject clientRepository;

    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<Client>> getSingleClient(@PathVariable int clientId) {
        return new ResponseEntity<Optional<Client>>(clientRepository.findClient(clientId), HttpStatus.OK);
    }
}
