/**
 * Not used for the LoginUseCase.
 * TODO This class should be deleted before we submit our project
 */

package consonants.flex.interface_adapter.login;

import consonants.flex.use_case.login.LoginOutputBoundary;
import consonants.flex.use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    @Override
    public Boolean doesClientExist(LoginOutputData loginOutputData){return loginOutputData.doesClientExist();}
}
