package consonants.flex.interface_adapter.upload_form;

import consonants.flex.data_access.mongo_data_access.DocumentRepository;
import consonants.flex.data_access.mongo_data_access.FileDataAccess;
import consonants.flex.data_access.mongo_data_access.NetworkDataAccess;
import consonants.flex.entity.FileDocument;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;


import java.io.IOException;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pdf/initial")

public class FileUploadController {
    @Autowired
    public DocumentRepository documentRepository;
    HttpHeaders headers = new HttpHeaders();

    //    @PostMapping
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
//
//        return new ResponseEntity<>("PDF Received: " + fileName, HttpStatus.CREATED);
//    }
    @PostMapping()
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String name, @RequestParam("claimId") int claimId){
        FileDataAccess dataAccessObject = new NetworkDataAccess(file);

        FileDocument result;
        Binary data;
        try {
            data = dataAccessObject.serializePDF();
            result = documentRepository.save(new FileDocument(name, claimId, data, LocalDate.now()));
            return new ResponseEntity<>(result.getId(), headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.BAD_REQUEST);
        }
    }

}
