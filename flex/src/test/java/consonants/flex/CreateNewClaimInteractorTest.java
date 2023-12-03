package consonants.flex;
import consonants.flex.entity.Claim;
import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
import consonants.flex.use_case.create_new_claim.CreateNewClaimInputData;
import consonants.flex.use_case.create_new_claim.CreateNewClaimInteractor;
import consonants.flex.use_case.create_new_claim.CreateNewClaimOutputData;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateNewClaimInteractorTest {
    @Mock
    private CreateNewClaimDataAccessInterface createNewClaimDataAccessObjectMock;
    @InjectMocks
    private CreateNewClaimInteractor createNewClaimInteractor;

    @Before
    void setup() {

        createNewClaimInteractor = new CreateNewClaimInteractor(createNewClaimDataAccessObjectMock); // instantiate the interactor
    }
    @Test
    public void createClaimTestExpectedId(){
        Claim outputClaim = new Claim(22,22); // output overrides createClaim method
        when(createNewClaimDataAccessObjectMock.createClaim(22)).thenReturn(outputClaim); // mock createClaim

        CreateNewClaimInputData inputClaim = new CreateNewClaimInputData(22); // create the input object
        CreateNewClaimOutputData claimOutput = createNewClaimInteractor.execute(inputClaim); // test execute
        assertEquals(claimOutput.getClaimId(), 22);
    }

    @Test
    public void createClaimTestNotExpectedId(){
        Claim outputClaim = new Claim(22,23); // output overrides createClaim method
        when(createNewClaimDataAccessObjectMock.createClaim(22)).thenReturn(outputClaim); // mock createClaim

        CreateNewClaimInputData inputClaim = new CreateNewClaimInputData(22); // create the input object
        CreateNewClaimOutputData claimOutput = createNewClaimInteractor.execute(inputClaim); // test execute
        assertNotEquals(claimOutput.getClaimId(), 22);
    }
}
