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

@RestController                 // @RestController automatically makes LoginController a Controller to FlexApplication.
@CrossOrigin(origins = "*")     // @CrossOrigin makes it so the Application can be run on any website?
@RequestMapping("/clients")       // "/clients" is the subdirectory that we want data to be retrieved from.
public class LoginController {
    @Autowired                  // @Autowired automatically instantiate the loginUseCaseInteractor (Spring style) in the constructor
    private LoginInputBoundary loginUseCaseInteractor;

    @GetMapping("/{clientId}")
    public ResponseEntity<Boolean> doesClientExist(@PathVariable int clientId) {
        LoginInputData loginInputData = new LoginInputData(clientId);
        return loginUseCaseInteractor.execute(loginInputData);
    }
}
