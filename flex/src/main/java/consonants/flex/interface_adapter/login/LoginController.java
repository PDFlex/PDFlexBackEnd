/**
 * Ben: I don't know what much of this code does; I just copy-pasted from the InformationController that was
 * used by Vithu in this project for testing purposes.
 */

package consonants.flex.interface_adapter.login;

import consonants.flex.Information;
import consonants.flex.InformationService;
import consonants.flex.entity.Client;
import consonants.flex.use_case.login.LoginInputBoundary;
import consonants.flex.use_case.login.LoginInputData;
import consonants.flex.use_case.login.LoginInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // This decorator automatically makes LoginController a Controller to FlexApplication.
@CrossOrigin(origins = "*") // Make it so this can be run on any website?
@RequestMapping("/login") // This is the subpage that we want the LoginUseCase to work on
public class LoginController {
    // @Autowired // Cannot Autowire (Autowiring is specific for Spring 'beans').
//    private LoginInputBoundary loginUseCaseInteractor; // Replaces informationService
    // Must use @Autowired when using Spring
    @Autowired
    private LoginInputBoundary loginUseCaseInteractor;
    public LoginController() {
        // In CA, we would have a loginUseCaseInteractor passed as a parameter to the LoginController constructor.
        // This is because the program starts in Main and you are able to construct things in there.
        // However, in Spring, the Controllers are the starting points. So we must create the Interactors here.

        // In CA, loginUseCaseInteractor are created with a LoginUseCaseFactory.
        // However, spoke with Lana, she said we will not be using factories (maybe should double-check with TAs).


//        this.loginUseCaseInteractor = new LoginInteractor();
        // Apparently this isnt needed (as per Lana).
    }

//    @GetMapping("/{firstName}")
    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<String>> getSingleInformation(@PathVariable int clientId) {
        LoginInputData loginInputData = new LoginInputData(clientId);
        return new ResponseEntity<Optional<String>>(loginUseCaseInteractor.execute(loginInputData), HttpStatus.OK);
    }
}
