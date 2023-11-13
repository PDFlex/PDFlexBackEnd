/**
 * Not used for the LoginUseCase (LoginInteractor returns a single value -- Boolean)
 * TODO This class should be deleted before we submit our project
 */

package consonants.flex.use_case.login;

public class LoginOutputData {
    private final Boolean clientExists;

    public LoginOutputData(Boolean clientExists) {this.clientExists = clientExists;}

    public Boolean doesClientExist(){return clientExists;}
}
