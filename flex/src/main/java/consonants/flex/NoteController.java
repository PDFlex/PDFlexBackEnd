package consonants.flex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pdf")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Note>(noteService.createNote(payload.get("noteBody"), payload.get("firstName")), HttpStatus.CREATED);
    }
}
