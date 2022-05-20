package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PrintTxt {
    public static void printTxt(String pathFile) {
        File f = new File(pathFile);
        System.out.println(f.getName() + " content:");
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
