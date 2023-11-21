package consonants.flex;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test the correctness of the LoginUseCase. These tests can be run directly without having the actual
 * FlexApplication running in the background (try it out yourself!).
 * This is accomplished by utilizing Spring's MockMvc to mock a server with the specified subdirectory
 * (e.g. localhost:8080/login/1234).
 * Doing it this way simulates exactly as if we were to process a real HTTP request.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LoginUseCaseTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests if the client with clientId '1234' exists in our database. Accomplishes this by looking
     * for the String "true" on the /login/1234 backend subdirectory (e.g. localhost:8080/login/1234).
     * Note: we will replace '1234' with an actual clientId in this
     * test once such is properly established in our MongoDB.
     */
    @Test
    void testClientExists() throws Exception {
        String subdirectory = "/login/1234"; // As in localhost:8080/login/1234
        String stringToCheck = "true";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests if the client with clientId '314159' exists in our database. Should be false.
     */
    @Test
    void testClientDoesNotExist() throws Exception {
        String subdirectory = "/login/314159";
        String stringToCheck = "false";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}