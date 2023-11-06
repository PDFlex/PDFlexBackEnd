/**
 * Here, we define the data that gets passed from frontend -> backend on 'Login' button click.
 * A new LoginInputData object is created each time the user clicks 'Login'.
 * The LoginController will be responsible for populating the LoginInputData's fields.
 * The information stored in LoginInputData will be used to execute the LoginInteractor.
 */

package consonants.flex.use_case.login;

public class LoginInputData {

    /**
     * We are assuming that the accountId String that was inputted in the HTML field has already been converted to int.
     */
    final private int accountId;

    public LoginInputData(int accountId) { this.accountId = accountId; }

    int getAccountId() { return accountId; }
}
