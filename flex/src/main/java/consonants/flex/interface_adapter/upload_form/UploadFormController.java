package consonants.flex.interface_adapter.upload_form;

import consonants.flex.use_case.upload_form.UploadFormInputBoundary;
import consonants.flex.use_case.upload_form.UploadFormInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping(value = "/pdf")
public class UploadFormController {
    @Autowired
    private UploadFormInputBoundary uploadInteractor;

    public UploadFormController(UploadFormInputBoundary uploadInteractor) {

        this.uploadInteractor = uploadInteractor;
    }
    @PostMapping()
    public void uploadForm(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String name, @RequestParam("claimId") int claimId) throws Exception{

        UploadFormInputData uploadInputData = new UploadFormInputData(file, name, claimId);
        uploadInteractor.execute(uploadInputData);

    }
}
