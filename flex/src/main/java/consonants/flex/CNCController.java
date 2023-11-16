package consonants.flex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/claim")
public class CNCController {
    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> createClaim(@RequestBody Map<String, String> clientId) {
        return new ResponseEntity<>("Hello!", HttpStatus.CREATED);

    }
}