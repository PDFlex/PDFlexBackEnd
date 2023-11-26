package consonants.flex.use_case.upload_form;

import consonants.flex.entity.*;
import org.bson.types.Binary;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface UploadFormDataAccessInterface{

    // run the OCR algorithm
    Map<String, Object> OCRLCInfoRequestCall(int claimId) throws Exception;

    // find an existing form object, so we can populate it with the OCR result
    void modifyForm(int claimId, Map<String, Object> formFields);
    String ExtractPDFBase64 (int claimId);

    void saveDocument(String fileName, int claimId, Binary data, LocalDate date);
}
