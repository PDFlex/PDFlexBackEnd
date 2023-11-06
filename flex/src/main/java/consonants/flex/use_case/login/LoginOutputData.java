/**
 * Here, we define the data that gets passed from frontend -> backend after the LoginInteractor has executed.
 */

package consonants.flex.use_case.login;

public class LoginOutputData {
    private final int accountId;
    private boolean useCaseFailed;

    /**
     * (Ben) Note: I would personally pass a Client instead of an int accountId, but I'm just following the CA
     * LoginUseCase example. Ultimately, I don't think it makes a difference (since you can always use the
     * DAO to create the Client instance afterwards).
     * @param accountId the accountId of the Client who is logging in.
     * @param useCaseFailed  true if the use case failed (as of right now, this will never be true because
     *                       fails are handled elsewhere). I suppose this is still good to have in the case
     *                       we wanted to display more information when the user does fail.
     */
    public LoginOutputData(int accountId, boolean useCaseFailed){
        this.accountId = accountId;
        this.useCaseFailed = useCaseFailed;
    }

    public int getAccountId() { return accountId; }
}
