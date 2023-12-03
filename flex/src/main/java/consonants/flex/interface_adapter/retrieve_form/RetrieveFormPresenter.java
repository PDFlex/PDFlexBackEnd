package consonants.flex.interface_adapter.retrieve_form;

import consonants.flex.entity.Form;
import consonants.flex.use_case.retrieve_form.RetrieveFormOutputBoundary;
import consonants.flex.use_case.retrieve_form.RetrieveFormOutputData;
import org.springframework.stereotype.Service;

@Service
public class RetrieveFormPresenter implements RetrieveFormOutputBoundary {
    @Override
    public Form retrieveForm(RetrieveFormOutputData outputData) {
        return outputData.getForm();
    }
}
