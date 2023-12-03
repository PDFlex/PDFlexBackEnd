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
 * Integration tests for the RetrieveFormUseCase.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RetrieveFormUseCaseTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests if Claim #1001 has its appropriate Form data.
     * I decided to test this by arbitrarily choosing a String that should be checked from the output on the page.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testFormDataExists() throws Exception {
        String subdirectory = "/form-info/1001";
        String stringToCheck = "ber\":\"(416) 485-6666\",\"occupation\":\"McDonald's employee\",\"employer\":\"McDonald's\",\"dateLastWorked\":\"01/02/2000\",\"workAddress\":\"196 Bloor St W,";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Form data of a
     * Claim that *does not* exist in the system.
     * In this example, Claim #222 do not exist in our database.
     * Note: We are going to adjust this test once the information in our database has been finalized for our Demo.
     */
    @Test
    void testClaimDoNotExist() throws Exception {
        String subdirectory = "/form-info/222";
        String stringToCheck = "";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}