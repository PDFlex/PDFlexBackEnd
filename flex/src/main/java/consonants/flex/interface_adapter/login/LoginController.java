package consonants.flex.interface_adapter.login;

import consonants.flex.use_case.login.LoginInputBoundary;
import consonants.flex.use_case.login.LoginInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                 // @RestController automatically makes LoginController a Controller to FlexApplication.
@CrossOrigin(origins = "*")     // @CrossOrigin makes it so the Application can be run on any website?
@RequestMapping("/login")       // "/login" is the subdirectory that we want data to be retrieved from.
public class LoginController {
    @Autowired                  // @Autowired injects (instantiates) the loginUseCaseInteractor automatically.
    private LoginInputBoundary loginUseCaseInteractor;

    @GetMapping("/{clientId}")
    public ResponseEntity<Boolean> doesClientExist(@PathVariable int clientId) {
        LoginInputData loginInputData = new LoginInputData(clientId);
        return loginUseCaseInteractor.execute(loginInputData);
    }
}
