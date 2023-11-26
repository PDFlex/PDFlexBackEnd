/**
 * LoginInteractor implements this interface.
 */

package consonants.flex.use_case.login;

import org.springframework.http.ResponseEntity;

public interface LoginInputBoundary {
    ResponseEntity<Boolean> execute(LoginInputData loginInputData);
}
