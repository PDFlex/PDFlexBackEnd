package consonants.flex.use_case.upload_form;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

public class UploadFormInputData {
    @Getter
    final private MultipartFile file;
    @Getter
    final private String name;
    @Getter
    final private int claimId;
    public UploadFormInputData(MultipartFile file, String name, int claimId) {

        this.file = file;
        this.name = name;
        this.claimId = claimId;
    }


//    String getBase64() {
//        return base64;
//    }

}
