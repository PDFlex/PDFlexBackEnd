package consonants.flex.data_access.mongo_data_access;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class NetworkDataAccess extends consonants.flex.data_access.mongo_data_access.FileDataAccess {

    MultipartFile file;

    public NetworkDataAccess(MultipartFile file) {
        this.file = file;
    }

    private byte[] convertPDFToByteArrayUsingFile() throws IOException {
        return file.getBytes();
    }

    @Override
    public Binary serializePDF() throws IOException {
        System.out.println(this.file);
        System.out.println(convertPDFToByteArrayUsingFile().getClass());
        System.out.println(byteArrayToBinary(convertPDFToByteArrayUsingFile()).getData());
        System.out.println(new String(byteArrayToBinary(convertPDFToByteArrayUsingFile()).getData()));


        return byteArrayToBinary(convertPDFToByteArrayUsingFile());
    }
}