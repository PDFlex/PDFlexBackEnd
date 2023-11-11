/**
 * The 'Brains' of the LoginUseCase.
 */

package consonants.flex.use_case.login;

import consonants.flex.entity.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Interactors become equivalent to Service (as in InformationService).
public class LoginInteractor implements LoginInputBoundary{
//    final LoginClientDataAccessInterface clientDataAccessObject; // No DAO? because LoginInteractor is never manually instantiated.

    public LoginInteractor(LoginClientDataAccessInterface clientDataAccessObject){
        // Here, we do not include an OutputBoundary.
        // This is because, in regular CA, we must reference the Presenter to pass it the OutputData
        // (giving the Presenter the appropriate information to display on the View).
        // However, in Spring, the Controller & Presenter are "combined".
        // And so, we make the initial `execute` call in the Controller, and it returns an OutputData.
        this.clientDataAccessObject = clientDataAccessObject;
    }

    @Override
    public Optional<String> execute(LoginInputData loginInputData) {
        // For simplicity's sake, we could directly pass the clientId instead of an entire LoginInputData object.
        // Using an InputData object is beneficial when multiple values are being passed
        // as it encapsulates everything into one.

        int clientId = loginInputData.getClientId();
        boolean clientExists = clientDataAccessObject.getClientById(clientId) == null;
        String err;
        if (clientExists) {
            err = "yay";
        } else {
            err = "boo! error!";
        }
        return err.describeConstable(); // Changes type from String to Optional<String>.
    }
}
