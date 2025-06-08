import java.nio.file.*;

public class SimpleFileOps {
    public static void main(String[] args) throws Exception {
        Path file = Paths.get("example.txt");

        // Write
        Files.writeString(file, "Hello, world!");

        // Read
        System.out.println(Files.readString(file));

        // Append
        Files.writeString(file, "\nNew line added.", StandardOpenOption.APPEND);
    }
}