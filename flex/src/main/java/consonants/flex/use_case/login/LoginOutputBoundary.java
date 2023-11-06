/**
 * Here, we define the methods that the Presenter should implement.
 */

package consonants.flex.use_case.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData loginOutputData);

    void prepareFailView(String error);
}
