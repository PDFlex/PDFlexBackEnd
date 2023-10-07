package consonants.PDFLex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "consonants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    // ignore this comment
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String githubRepo;
    private List<String> backdrops;
//    @DocumentReference
//    private List<Note> notesIds;
}
