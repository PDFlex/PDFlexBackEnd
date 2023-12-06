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
 * Integration tests for the ViewFormsDashboardUseCase.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ViewFormsDashboardUseCaseTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests if the Client #10002 with Claim #1003 has its appropriate Form data.
     * We decided to test this by arbitrarily choosing a String that should be checked from the output on the page.
     */
    @Test
    void testClient10002Claim1003DataExists() throws Exception {
        String subdirectory = "/10002/1003/forms";
        String stringToCheck = "[{\"id\":{\"timestamp\":1701904511,\"date\":\"2023-12-06T23:15:11.000+00:00\"},\"status\":\"IN_PROGRESS\",\"formId\":3,\"clientId\":10002,\"claimId\":1003,";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Form data of a
     * Client and Claim that *do not* exist in the system.
     * In this example, both Client #111 Claim #222 do not exist in our database.
     */
    @Test
    void testClientAndClaimDoNotExist() throws Exception {
        String subdirectory = "/111/222/forms";
        String stringToCheck = "[]";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}