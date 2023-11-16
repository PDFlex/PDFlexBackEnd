package consonants.flex.interface_adapter.create_new_claim;

import consonants.flex.use_case.create_new_claim.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/pdf")
public class CreateNewClaimController {
    CreateNewClaimInputBoundary createNewClaimInteractor;
    public CreateNewClaimController(CreateNewClaimInputBoundary createNewClaimInteractor){
        this.createNewClaimInteractor = createNewClaimInteractor;
    }

////    @PostMapping("/pdf")
////    @CrossOrigin
////    public ResponseEntity<> execute(@RequestBody Map<String, String> payload) {
////        return new ResponseEntity<>(noteService.createNote(payload.get("noteBody"), payload.get("firstName")), HttpStatus.CREATED);
////    }
//
//    @PostMapping("/pdf")
//    @CrossOrigin
//    public void executer(@RequestBody Map<String, String> payload) {
//        String[] storage = new String[]{payload.get("file"), payload.get("fileName")};
//        console.log(storage);
//    }
    public void execute(int clientId) {
        CreateNewClaimInputData createNewClaimInputData = new CreateNewClaimInputData(clientId);

        createNewClaimInteractor.execute(createNewClaimInputData);
    }
}
