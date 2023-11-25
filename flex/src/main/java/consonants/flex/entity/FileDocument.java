package consonants.flex.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import org.bson.types.Binary;

@Document("documents")
public class FileDocument {
    @Getter
    @Id
    private String id;
    private int claimId;

    public String name;
    private final Binary content;
    public LocalDate timeStamp;

    public FileDocument(String name, int claimId, Binary content, LocalDate timeStamp) {
        this.content = content;
        this.name = name;
        this.timeStamp = timeStamp;
        this.claimId = claimId;
    }

    public void setId(String id) { this.id = id; }

}