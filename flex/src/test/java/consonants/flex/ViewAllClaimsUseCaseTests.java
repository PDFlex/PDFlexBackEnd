package consonants.flex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for the ViewAllClaimsUseCase.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ViewAllClaimsUseCaseTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests if all the data associated with Claim #1001 exists.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClaim1001DataExists() throws Exception {
        String subdirectory = "/claims";
        String stringToCheck = "{\"id\":{\"timestamp\":1700286748,\"date\":\"2023-11-18T05:52:28.000+00:00\"},\"forms\":[3],\"claimId\":1001,\"clientId\":1234,\"status\":\"INCOMPLETE\"}";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests if all the data associated with Claim #1002 exists.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClaim1002DataExists() throws Exception {
        String subdirectory = "/claims";
        String stringToCheck = "{\"id\":{\"timestamp\":1700329276,\"date\":\"2023-11-18T17:41:16.000+00:00\"},\"forms\":[2],\"claimId\":1002,\"clientId\":5678,\"status\":\"INCOMPLETE\"}";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}