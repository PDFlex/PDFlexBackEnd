/**
 * Here, we define the data that gets passed from frontend -> backend after the LoginInteractor has executed.
 */

package consonants.flex.use_case.login;

public class LoginOutputData {
    private final Boolean clientExists;

    public LoginOutputData(Boolean clientExists) {this.clientExists = clientExists;}

    public Boolean doesClientExist(){return clientExists;}
}
