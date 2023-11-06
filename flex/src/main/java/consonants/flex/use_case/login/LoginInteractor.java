/**
 * The 'Brains' of the LoginUseCase.
 */

package consonants.flex.use_case.login;

public class LoginInteractor implements LoginInputBoundary{
    final LoginClientDataAccessInterface clientDataAccessObject;
//    final LoginOutputBoundary loginPresenter; // TODO

    public LoginInteractor(LoginClientDataAccessInterface clientDataAccessObject,
                           LoginOutputBoundary loginOutputBoundary) {
        this.clientDataAccessObject = clientDataAccessObject;
//        this.loginPresenter = LoginOutputBoundary; // TODO
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        /**
         * TODO:
         * - read the id that was inputted in the HTML field
         * - If this id exists in the database:
         *      - somehow trigger ViewClaimsDashboardUseCase
         * - Otherwise:
         *      - Somehow alert to front end that the id is invalid
         */

        final int accountId = loginInputData.getAccountId();
//        if (!clientDataAccessObject.)

    }
}
