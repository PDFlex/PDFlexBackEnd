package consonants.flex.use_case.upload_form;

public class UploadFormInputData {
    final private String base64;
    public UploadFormInputData(String base64) {
        this.base64 = base64;
    }


    String getBase64() {
        return base64;
    }

}
