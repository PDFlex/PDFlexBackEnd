package consonants.flex.use_case.retrieve_form;

import lombok.Getter;

@Getter
public class RetrieveFormInputData {
    int claimId;
    public RetrieveFormInputData(int claimId){
        this.claimId = claimId;
    }
}
