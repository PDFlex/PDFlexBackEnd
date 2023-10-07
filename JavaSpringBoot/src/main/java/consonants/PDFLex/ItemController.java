package consonants.PDFLex;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/items")
public class ItemController {
    // ignore this comment
    @Autowired
    private ItemService itemService;
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<List<Item>>(itemService.allItems(), HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Optional<Item>> getSingleItem(@PathVariable String firstName) {
        return new ResponseEntity<Optional<Item>>(itemService.singleItem(firstName), HttpStatus.OK);
    }
}
