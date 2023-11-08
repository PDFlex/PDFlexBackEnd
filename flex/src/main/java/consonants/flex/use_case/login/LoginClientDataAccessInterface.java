/**
 * Ben's personal notes:
 * Javadoc examples + tutorial: https://faculty.kutztown.edu/spiegel/JavadocTutorial.html
 *
 * This interface defines all the methods that the LoginUseCase will need
 * from the database in order to fulfill its needs.
 * Eventually, a "FileUserDataAccessObject" will be made that implements all the methods defined here.
 * The LoginInteractor will reference this FileUserDataAccessObject.
 */

package consonants.flex.use_case.login;

import consonants.flex.entity.Client;

public interface LoginClientDataAccessInterface {
    /**
     * @param clientId the id of the Client.
     * @return True if the Client with the given id exists in the database; False otherwise.
     */
//    boolean clientExistsById(int clientId);

    /**
     * Unsure if this method is needed in this interface; will delete if unneeded.
     * @param clientId the id of the Client.
     * @return the Client.
     */
    Client getClientById(int clientId);
}
