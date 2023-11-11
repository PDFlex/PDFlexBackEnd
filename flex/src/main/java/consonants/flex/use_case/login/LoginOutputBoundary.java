/**
 * Here, we define the methods that the Presenter should implement.
 */

package consonants.flex.use_case.login;

public interface LoginOutputBoundary {
    Boolean doesClientExist(LoginOutputData loginOutputData);
}
