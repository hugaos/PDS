import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Document {
    private String filename;
    private String content;

    public Document(String filename) {
        this.filename = filename;
        this.content=loadContent();
    }

    // Simulate loading content from a file

    // Getter for filename
    public String getFilename() {
        return filename;
    }
    public String getContent() {
        return content;
    }  
    // Getter for content
    public String loadContent() {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Returns null if there's an error reading the file
        }
    }

    // Setter for content, if needed for updates
    public void setContent(String content) {
        this.content = content;
    }

    
}
