/**
 * The 'Brains' of the LoginUseCase.
 */

package consonants.flex.use_case.login;

import consonants.flex.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginInteractor implements LoginInputBoundary{

    @Autowired
    private LoginClientDataAccessInterface clientDataAccessObject;

//    @Autowired
//    private LoginOutputBoundary loginPresenter;
    public LoginInteractor(LoginClientDataAccessInterface clientDataAccessObject){ // I don't think this is necessary
        this.clientDataAccessObject = clientDataAccessObject;
    }

    @Override
    public ResponseEntity<Boolean> execute(LoginInputData loginInputData) {
        int clientId = loginInputData.getClientId();
        Boolean doesExist;
        Optional<Client> c = clientDataAccessObject.findClientById(clientId); // THIS DOESN'T WORK
        doesExist = (c != null);
        return new ResponseEntity<Boolean>(doesExist, HttpStatus.OK);
    }
}
