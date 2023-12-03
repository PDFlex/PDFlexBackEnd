package consonants.flex.use_case.retrieve_form;

import consonants.flex.entity.Form;

import java.util.List;

public interface RetrieveFormDataAccessInterface {

    /**
     * Retrieves Form objects from the MongoDB with the corresponding unique formIds.
     * @param clientId is the Client whose claim we are looking at. Uses this to generate list of claimIds that verifies
     *                 if we are looking at the correct claim.
     * @param claimId refers to the Claim containing the forms of interest.
     * @return A list of Form objects with the formIds specified in the getClaimFormIds call; empty if this list is empty
     */
    public List<Form> getFormsListAsForms(int clientId, int claimId);
    public Form getFirstForm(int clientId);


    }
