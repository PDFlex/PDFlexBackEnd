//package consonants.flex;
//
//import com.mongodb.client.result.UpdateResult;
//import consonants.flex.data_access.mongo_data_access.ClaimRepository;
//import consonants.flex.data_access.mongo_data_access.MongoDataAccessObject;
//import consonants.flex.entity.Claim;
//import consonants.flex.entity.Client;
//import consonants.flex.use_case.create_new_claim.CreateNewClaimDataAccessInterface;
//import consonants.flex.use_case.create_new_claim.CreateNewClaimInputData;
//import consonants.flex.use_case.create_new_claim.CreateNewClaimInteractor;
//import consonants.flex.use_case.create_new_claim.CreateNewClaimOutputData;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Answers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import org.mockito.stubbing.Answer;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Update;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class CreateClaimTest {
//
//        // dependencies (to be mocked)
//        @Mock
//        ClaimRepository claimRepository;
//        @Mock(answer = Answers.RETURNS_MOCKS)
//        MongoTemplate mongoTemplate;
//
//        // class to test
//        private MongoDataAccessObject mongoDataAccessObject = new MongoDataAccessObject();
//
//        @InjectMocks
//        private CreateNewClaimInteractor createNewClaimInteractor;
//
//        @Before
//        void setup() {
////            List<Claim> claimsList = new ArrayList<>();
////            claimsList.add(new Claim(100, 1001));
////            claimsList.add(new Claim(101, 1002));
////
////            Claim inputClaim = new Claim(102, 1003);
////
////            when(claimRepository.findAll()).thenReturn(claimsList);
////
////            when(claimRepository.insert(inputClaim));
//
////            when(mongoTemplate.update(Client.class).matching(Criteria.where("clientId").is(clientId))
////                    .apply(new Update().push("claimsList").value(expectedClaimId))
////                    .first());
//
//        }
//        @Test
//        public void mongoCreateClaimTestId(){
//            List<Claim> claimsList = new ArrayList<>();
//            claimsList.add(new Claim(100, 1001));
//            claimsList.add(new Claim(101, 1002));
//            when(claimRepository.findAll()).thenReturn(claimsList);
//            Claim testClaim = mongoDataAccessObject.createClaim(102);
//            assertEquals(testClaim.getClaimId(), 1003);
//
//        }
//    }

