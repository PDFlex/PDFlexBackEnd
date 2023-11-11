package consonants.flex.interface_adapter.login;

import consonants.flex.use_case.login.LoginOutputBoundary;
import consonants.flex.use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    @Override
    public Boolean doesClientExist(LoginOutputData loginOutputData){return loginOutputData.doesClientExist();}
}
