package consonants.flex.use_case.view_all_claims;

import org.springframework.http.HttpStatus;
import consonants.flex.entity.Claim;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ViewAllClaimsInteractor implements ViewAllClaimsInputBoundary{

    @Autowired
    final ViewAllClaimsDataAccessInterface claimsDataAccessObject;

    @Autowired
    final ViewAllClaimsOutputBoundary outputBoundary;

    public ViewAllClaimsInteractor(ViewAllClaimsDataAccessInterface claimsDataAccessObject, ViewAllClaimsOutputBoundary outputBoundary) {
        this.claimsDataAccessObject = claimsDataAccessObject;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ResponseEntity<List<Claim>> execute() {
        List<Claim> claimsList = (claimsDataAccessObject.allClaims());
        ViewAllClaimsOutputData outputData = new ViewAllClaimsOutputData(claimsList);
        return new ResponseEntity<List<Claim>>(outputBoundary.viewAllClaims(outputData), HttpStatus.OK);
    }
}
