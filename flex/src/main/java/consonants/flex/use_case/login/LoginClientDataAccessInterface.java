/**
 * This interface defines all the methods that the LoginUseCase will need
 * from the database in order to fulfill its needs.
 */

package consonants.flex.use_case.login;

public interface LoginClientDataAccessInterface {
    /**
     * @param clientId the id of the Client.
     * @return True if the Client with the given id exists in the database; False otherwise.
     */
    Boolean clientExistsById(int clientId);

}
