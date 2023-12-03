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
     * Tests if the Client #1234 has a Claim #1010 and its associated data.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClient1234DataExists() throws Exception {
        String subdirectory = "/1234/claims";
        String stringToCheck = "{\"id\":{\"timestamp\":1700435491,\"date\":\"2023-11-19T23:11:31.000+00:00\"},\"forms\":[12],\"claimId\":1010,\"clientId\":1234,\"status\":\"INCOMPLETE\"}";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests if the Client #5678 has a Claim #1022 and its associated data.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClient5678DataExists() throws Exception {
        String subdirectory = "/5678/claims";
        String stringToCheck = "{\"id\":{\"timestamp\":1700286748,\"date\":\"2023-11-18T05:52:28.000+00:00\"},\"forms\":[3],\"claimId\":1001,\"clientId\":1234,\"status\":\"INCOMPLETE\"}";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Claims of a Client that
     * does not exist in the database (e.g. Client #9999).
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClientDataDoesNotExist() throws Exception {
        String subdirectory = "/9999/claims";
        String stringToCheck = "[]";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}