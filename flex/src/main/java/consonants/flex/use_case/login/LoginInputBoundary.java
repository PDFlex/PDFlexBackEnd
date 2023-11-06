/**
 * LoginInteractor implements this interface.
 */

package consonants.flex.use_case.login;

public interface LoginInputBoundary {

    /**
     * Defines what data is needed from the front-end (see LoginInputData class).
     */
    void execute(LoginInputData loginInputData);
}
