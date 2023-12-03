package consonants.flex.use_case.retrieve_form;

import consonants.flex.entity.Form;

import java.util.List;

public interface RetrieveFormOutputBoundary {
    Form retrieveForm(RetrieveFormOutputData outputData);

}
