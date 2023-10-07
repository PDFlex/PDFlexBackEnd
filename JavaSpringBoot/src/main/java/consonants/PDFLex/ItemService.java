package consonants.PDFLex;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    // ignore this comment
    @Autowired
    private ItemRepository itemRepository;
    public List<Item> allItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> singleItem(String firstName) {
        return itemRepository.findItemByFirstName(firstName);
    }
}
