import java.io.*;

public class FileHandler {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Writing to a file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is a test file.\n");
            writer.write("File handling in Java is simple!");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nReading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Modifying a file (appending text)
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\nAppending some new text!");
            System.out.println("\nText appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}