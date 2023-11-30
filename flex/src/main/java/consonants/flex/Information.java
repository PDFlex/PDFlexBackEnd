package consonants.flex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "clients") // The collection we want it to access. Click the green leaf beside `public class Information` to see the corresponding collection.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    // ignore this comment
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
//    private String githubRepo;
    private String clientId;
    private List<String> backdrops;
//    @DocumentReference
//    private List<Note> notesIds;
}
