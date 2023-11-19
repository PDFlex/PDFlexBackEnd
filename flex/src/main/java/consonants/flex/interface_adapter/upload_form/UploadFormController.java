package consonants.flex.interface_adapter.upload_form;

import consonants.flex.use_case.upload_form.UploadFormInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadFormController {
    @Autowired
    private UploadFormInputBoundary uploadInteractor;

    public void uploadForm(String pdfUrl) throws Exception{
        uploadInteractor.execute(pdfUrl);
    }
}
