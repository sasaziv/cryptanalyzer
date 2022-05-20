package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class WriteTxt {

    public static void writeFile(List<String> lines, String filePath) {
        CreateFile.createFile(filePath);
        try {
            Path path = Path.of(filePath);
            Files.write(path, lines);
            System.out.println("Changes have been successfully saved!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong! Your changes have not been saved.");
        }
    }
}
