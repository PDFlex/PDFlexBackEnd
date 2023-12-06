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
     * Tests if all the data associated with Claim #1002 exists.
     */
    @Test
    void testClaim1002DataExists() throws Exception {
        String subdirectory = "/claims";
        String stringToCheck = "{\"id\":{\"timestamp\":1701904501,\"date\":\"2023-12-06T23:15:01.000+00:00\"},\"forms\":[2],\"claimId\":1002,\"clientId\":10002,\"status\":\"INCOMPLETE\",\"createdClaimDate\":\"2023-12-06\"}";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}