package consonants.flex.example.uploadingfiles.storage;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Getter
@ConfigurationProperties("storage")

public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	public void setLocation(String location) {
		this.location = location;
	}

}
