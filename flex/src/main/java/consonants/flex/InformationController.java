//package consonants.flex;
//
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/information")
//public class InformationController {
//    // ignore this comment
//    @Autowired
//    private InformationService informationService;
//    @GetMapping
//    public ResponseEntity<List<Information>> getAllInformation() {
//        return new ResponseEntity<List<Information>>(informationService.allInformation(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{firstName}")
//    public ResponseEntity<Optional<Information>> getSingleInformation(@PathVariable String firstName) {
//        return new ResponseEntity<Optional<Information>>(informationService.singleInformation(firstName), HttpStatus.OK);
//    }
//    @PostMapping("/new-claim")
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<Object> execute(@RequestBody Map<String, String> clientId) {
//        return new ResponseEntity<>(HttpStatus.CREATED);
//
//    }
//}
