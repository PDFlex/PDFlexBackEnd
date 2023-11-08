/**
 * The 'Brains' of the LoginUseCase.
 */

package consonants.flex.use_case.login;

import consonants.flex.entity.Client;

public class LoginInteractor implements LoginInputBoundary{
    final LoginClientDataAccessInterface clientDataAccessObject;

    public LoginInteractor(LoginClientDataAccessInterface clientDataAccessObject){
        // Here, we do not include an OutputBoundary.
        // This is because, in regular CA, we must reference the Presenter to pass it the OutputData
        // (giving the Presenter the appropriate information to display on the View).
        // However, in Spring, the Controller & Presenter are "combined".
        // And so, we make the initial `execute` call in the Controller, and it returns an OutputData.
        this.clientDataAccessObject = clientDataAccessObject;
    }

    @Override
    public LoginOutputData execute(LoginInputData loginInputData) {
        // For simplicity's sake, we could directly pass the clientId instead of an entire LoginInputData object.
        // Using an InputData object is beneficial when multiple values are being passed
        // as it encapsulates everything into one.

        int clientId = loginInputData.getClientId();
        //boolean doesClientExist = clientDataAccessObject.existsById(clientId)
        Client client = clientDataAccessObject.getClientById(clientId);
        LoginOutputData loginOutputData = new LoginOutputData(clientId, true);
        System.out.println(client);
        return loginOutputData;
//        if (client) {
        // loginPresenter.prepareFailView("Client with ID " + toString(clientId) + " does not exist!");
//        } else {
//            boolean useCaseFailed = false;
//            Client client = clientDataAccessObject.get(clientId);
//            LoginOutputData loginOutputData = new LoginOutputData(clientId, useCaseFailed);
            // loginPresenter.prepareSuccessView(loginOutputData);
            // TODO: how do we trigger ViewClaimsDashboardUseCase?
//        }

    }
}
