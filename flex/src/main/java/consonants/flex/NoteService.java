package consonants.flex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Note createNote(String noteBody, String firstName) {
        Note note = noteRepository.insert(new Note(noteBody));

        mongoTemplate.update(Information.class)
                .matching(Criteria.where("firstName").is(firstName))
                .apply(new Update().push("notesIds").value(note))
                .first();

        return note;
    }
}
