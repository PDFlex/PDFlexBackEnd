package consonants.flex;

import consonants.flex.use_case.upload_form.UploadFormDataAccessInterface;
import consonants.flex.use_case.upload_form.UploadFormInputData;
import consonants.flex.use_case.upload_form.UploadFormInteractor;
import org.bson.types.Binary;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.mock.web.MockMultipartFile;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UploadFormInteractorTest {
    @Mock
    private UploadFormDataAccessInterface uploadFormDataAccessObjectMock;
    @InjectMocks
    private UploadFormInteractor uploadFormInteractor;

    @Before
    public void setup() {
        uploadFormInteractor = new UploadFormInteractor(uploadFormDataAccessObjectMock);
    }
    @Test
    public void uploadFormExpectedOCRResult() throws Exception {
        Binary data = new Binary("test".getBytes());
        MockMultipartFile mockFile = new MockMultipartFile(
                "toby.pdf",
                "toby.pdf",
                "application/pdf",
                data.getData());

        // create the input object
        UploadFormInputData uploadInputData = new UploadFormInputData(mockFile, "toby.pdf", 1239);

        // mock the OCR result
        Map<String, Object> OCRResultMap = new HashMap<>();
        OCRResultMap.put("deceasedName", "Toby, Quinlan");
        OCRResultMap.put("employer", "McDonald's");
        when(uploadFormDataAccessObjectMock.OCRLCInfoRequestCall(1239)).thenReturn(OCRResultMap);

        // saveDocument is void, so we have it return null
        doAnswer((Answer<Void>) invocation -> null).when(uploadFormDataAccessObjectMock).saveDocument(uploadInputData.getName(), uploadInputData.getClaimId(), data, LocalDate.now());
        // modifyForm is void, so we have it return null
        doAnswer((Answer<Void>) invocation -> null).when(uploadFormDataAccessObjectMock).modifyForm(uploadInputData.getClaimId(), OCRResultMap);

        // test the execute method
        uploadFormInteractor.execute(uploadInputData);

    }

}
