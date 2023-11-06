/**
 * The 'Brains' of the LoginUseCase.
 */

package consonants.flex.use_case.login;

import consonants.flex.entity.Client;

public class LoginInteractor implements LoginInputBoundary{
    final LoginClientDataAccessInterface clientDataAccessObject;
    // final LoginOutputBoundary loginPresenter; // TODO

    public LoginInteractor(LoginClientDataAccessInterface clientDataAccessObject,
                           LoginOutputBoundary loginOutputBoundary) {
        this.clientDataAccessObject = clientDataAccessObject;
        // this.loginPresenter = LoginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        int accountId = loginInputData.getAccountId();
        if (!clientDataAccessObject.existsById(accountId)) {
        // loginPresenter.prepareFailView("Client with ID " + toString(accountId) + " does not exist!");
        } else {
            boolean useCaseFailed = false;
            Client client = clientDataAccessObject.get(accountId);
            LoginOutputData loginOutputData = new LoginOutputData(accountId, useCaseFailed);
            // loginPresenter.prepareSuccessView(loginOutputData);
            // TODO: how do we trigger ViewClaimsDashboardUseCase?
        }

    }
}
