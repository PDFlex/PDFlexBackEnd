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
 * Integration tests for the ViewClaimsDashboardUseCase.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ViewClaimsDashboardUseCaseTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests if the Client #10002 has a Claim #1003 and its associated data.
     */
    @Test
    void testClient10002DataExists() throws Exception {
        String subdirectory = "/10002/claims";
        String stringToCheck = "{\"id\":{\"timestamp\":1701926255,\"date\":\"2023-12-07T05:17:35.000+00:00\"},\"forms\":[3],\"claimId\":1003,\"clientId\":10002,\"status\":\"INCOMPLETE\",\"createdClaimDate\":\"2023-12-07\"}";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Claims of a Client that
     * does not exist in the database (e.g. Client #9999).
     */
    @Test
    void testClientDataDoesNotExist() throws Exception {
        String subdirectory = "/9999/claims";
        String stringToCheck = "[]";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}