package consonants.flex;
import consonants.flex.data_access.mongo_data_access.ClaimRepository;
import consonants.flex.data_access.mongo_data_access.MongoDataAccessObject;
import consonants.flex.entity.Claim;
import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
import consonants.flex.use_case.create_new_claim.CreateNewClaimInteractor;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Switch.CaseOperator.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
public class CreateNewClaimTest {
    @Mock
    private CreateNewClaimDataAccessInterface createNewClaimDataAccessObjectMock;
    @InjectMocks
    private CreateNewClaimInteractor createNewClaimInteractor;
    @Mock
    private ClaimRepository claimRepository;

//    @Before
//    public void setup(){
//        createNewClaimDataAccessObjectMock = mock(MongoDataAccessObject.class);
//        claimRepository = mock(ClaimRepository.class);
//        createNewClaimInteractor = new CreateNewClaimInteractor(createNewClaimDataAccessObjectMock);
//
//        Claim sampleClaim = new Claim(2,2);
//        when((AggregationExpression) claimRepository.findAll()).then(2);
//
//    }

    @Before
    void setup() {
        createNewClaimDataAccessObjectMock = Mockito.mock(CreateNewClaimDataAccessInterface.class);
        createNewClaimInteractor = new CreateNewClaimInteractor(createNewClaimDataAccessObjectMock);

        when(claimRepository.findAll()).thenReturn("test"); //TODO: not sure why this isn't working
    }
    @Test
    public void test(){

    }
}
