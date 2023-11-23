package consonants.flex.interface_adapter.upload_form;

import consonants.flex.use_case.upload_form.UploadFormInputBoundary;
import consonants.flex.use_case.upload_form.UploadFormInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping(value = "/uploadtest")
public class UploadFormController {
    @Autowired
    private UploadFormInputBoundary uploadInteractor;

    public UploadFormController(UploadFormInputBoundary uploadInteractor) {

        this.uploadInteractor = uploadInteractor;
    }
    @PostMapping("/form")
    public void uploadForm(@RequestBody String base64PDF) throws Exception{

        System.out.println(base64PDF);
        UploadFormInputData uploadInputData = new UploadFormInputData(base64PDF);
        uploadInteractor.execute(uploadInputData);
    }
}
