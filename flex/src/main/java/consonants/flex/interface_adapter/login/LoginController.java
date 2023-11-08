/**
 * Ben: I don't know what much of this code does; I just copy-pasted from the InformationController that was
 * used by Vithu in this project for testing purposes.
 */

package consonants.flex.interface_adapter.login;

import consonants.flex.Information;
import consonants.flex.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login") // This is the subpage that we want the LoginUseCase to work on
public class LoginController {
    // ignore this comment
    @Autowired
    private InformationService informationService;
    @GetMapping
    public ResponseEntity<List<Information>> getAllInformation() {
        return new ResponseEntity<List<Information>>(informationService.allInformation(), HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Optional<Information>> getSingleInformation(@PathVariable String firstName) {
        return new ResponseEntity<Optional<Information>>(informationService.singleInformation(firstName), HttpStatus.OK);
    }
}
