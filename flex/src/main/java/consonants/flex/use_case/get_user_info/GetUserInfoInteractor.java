package consonants.flex.use_case.get_user_info;

import consonants.flex.entity.Client;
import org.springframework.http.HttpStatus;
import consonants.flex.entity.Claim;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetUserInfoInteractor implements GetUserInfoInputBoundary{

//    @Autowired
    final GetUserInfoDataAccessInterface getUserInfoDataAccessObject;

//    @Autowired
    final GetUserInfoOutputBoundary getUserInfoPresenter;

    public GetUserInfoInteractor(GetUserInfoDataAccessInterface getUserInfoDataAccessObject, GetUserInfoOutputBoundary getUserInfoPresenter) {
        this.getUserInfoDataAccessObject = getUserInfoDataAccessObject;
        this.getUserInfoPresenter = getUserInfoPresenter;
    }

    @Override
    public ResponseEntity<Client> execute(int accountId) {
        Client client = getUserInfoDataAccessObject.findClient(accountId);
        GetUserInfoOutputData outputData = new GetUserInfoOutputData(client, client.getClaimsList());
        return new ResponseEntity<Client>(getUserInfoPresenter.getUserInfo(outputData), HttpStatus.OK);
    }
}
