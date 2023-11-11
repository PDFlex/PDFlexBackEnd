/**
 * LoginInteractor implements this interface.
 */

package consonants.flex.use_case.login;

import org.springframework.http.ResponseEntity;

public interface LoginInputBoundary {

    /**
     * Defines what data is needed from the front-end (see LoginInputData class).
     * Normally in CA, the return value is 'void'. See the comments in the LoginInteractor for an explanation
     * as to why we return LoginOutputData.
     */
    ResponseEntity<Boolean> execute(LoginInputData loginInputData);
}
