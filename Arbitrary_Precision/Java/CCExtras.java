import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

public class CCExtras {
    
    public static void writeToFile(Path filePath, String text, boolean append) {
        if (append) {
            try {
                Files.write(filePath, text.getBytes(StandardCharsets.UTF_8), 
                     StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.writeString(filePath, text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}