package main;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadTxt {
    private static List<String> lines = new ArrayList<>();

    public static List<String> readTxt(String path) {
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }



    //    public static List<String> readTxt(String path) {
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line = reader.readLine();
//            while (line != null) {
//                lines.add(line);
//                line = reader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }
}
