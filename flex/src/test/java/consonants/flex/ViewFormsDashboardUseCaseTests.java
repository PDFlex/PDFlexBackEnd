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
     * Tests if the Client #1234 with Claim #1010 has its appropriate Form data.
     * I decided to test this by arbitrarily choosing a String that should be checked from the output on the page.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClient1234Claim1010DataExists() throws Exception {
        String subdirectory = "/1234/1010/forms";
        String stringToCheck = "cianNames\":[],\"pastPhysicianAddresses\":[],\"attendingPhysicianName\":\"Taylor Lindy\",\"attendingPhysicianAddress\":\"312 Queen St";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Form data of a Client who *does*
     * exist but whose Claim *does not* exist.
     * In this example, Client #1234 does exist but Claim #1001 does not exist to them (it exists to Client #5678).
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClientExistsClaimDoesNotExist() throws Exception {
        String subdirectory = "/1234/1001/forms";
        String stringToCheck = "[]";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Form data of a Client who
     * *does not* exist but whose Claim *does* exist to some Client.
     * In this example, Client #69420 does not exist but Claim #1001 does exist in the system (in particular,
     * it belongs to Client #5678).
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClientDoesNotExistClaimExists() throws Exception {
        String subdirectory = "/69420/1001/forms";
        String stringToCheck = "[]";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Form data of a
     * Client and Claim that *do not* exist in the system.
     * In this example, both Client #111 Claim #222 do not exist in our database.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClientAndClaimDoNotExist() throws Exception {
        String subdirectory = "/111/222/forms";
        String stringToCheck = "[]";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}