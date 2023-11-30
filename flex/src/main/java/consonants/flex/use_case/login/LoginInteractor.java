package consonants.flex.use_case.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginInteractor implements LoginInputBoundary{
    @Autowired
    private LoginClientDataAccessInterface clientDataAccessObject;

    @Override
    public ResponseEntity<Boolean> execute(LoginInputData loginInputData) {
        int clientId = loginInputData.getClientId();
        Boolean doesExist = clientDataAccessObject.clientExistsById(clientId);
        return new ResponseEntity<>(doesExist, HttpStatus.OK);
        // We skip returning an OutputData because our OutputData is simple--a Boolean.
        // So we just return the Boolean directly (within the ResponseEntity).
        // This is also why the LoginUseCase doesn't have a Presenter and OutputBoundary.
    }
}
