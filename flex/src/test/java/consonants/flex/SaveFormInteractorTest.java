package consonants.flex;

import consonants.flex.use_case.save_form.SaveFormDataAccessInterface;
import consonants.flex.use_case.save_form.SaveFormInteractor;
import consonants.flex.use_case.save_form.SaveFormInputData;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

/**
 * Interactor test for the SaveForm use case using Mockito.
 */
@ExtendWith(MockitoExtension.class)

public class SaveFormInteractorTest {

    @Mock
    private SaveFormDataAccessInterface saveFormDataAccessObjectMock;
    @InjectMocks
    private SaveFormInteractor saveFormInteractor;

    @Before
    public void setup() {
        saveFormInteractor = new SaveFormInteractor(saveFormDataAccessObjectMock);
    }

    /**
     * Tests if we get the 200 status code upon executing the SaveForm use case
     */
    @Test
    public void saveFormExpectedSuccessStatus(){
        // mapping for OCR form fields
        Map<String, Object> OCRResultMap = new HashMap<>();

        // create the input object
        SaveFormInputData saveInputData = new SaveFormInputData(OCRResultMap, 123499);

        // modifyForm is void, so we have it return null
        doAnswer((Answer<Void>) invocation -> null).when(saveFormDataAccessObjectMock).modifyForm(saveInputData.getClaimId(), OCRResultMap);

        // test the execute method + status
        ResponseEntity<Object> outputFormFields = saveFormInteractor.execute(saveInputData);
        assertEquals(outputFormFields.getStatusCodeValue(), 200);

    }

    /**
     * Tests if the correct OCR Result is being saved by the SaveForm use case.
     */
    @Test
    public void saveFormExpectedOCRResultSaved(){
        // mock the OCR result
        Map<String, Object> OCRResultMap = new HashMap<>();
        OCRResultMap.put("deceasedName", "Jimmy, Kim");
        OCRResultMap.put("employer", "Shopify");
        OCRResultMap.put("relationshipToInsured", "Mother");

        // create the input object
        SaveFormInputData saveInputData = new SaveFormInputData(OCRResultMap, 123499);

        // modifyForm is void, so we have it return null
        doAnswer((Answer<Void>) invocation -> null).when(saveFormDataAccessObjectMock).modifyForm(saveInputData.getClaimId(), OCRResultMap);

        // test the execute method + OCR Result being saved
        saveFormInteractor.execute(saveInputData);
        assertEquals(saveInputData.getFormFields().get("deceasedName"), "Jimmy, Kim");
        assertEquals(saveInputData.getFormFields().get("employer"), "Shopify");
        assertEquals(saveInputData.getFormFields().get("relationshipToInsured"), "Mother");

    }
}


