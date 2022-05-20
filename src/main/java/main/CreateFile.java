package main;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void createFile(String filePath) {
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName() + ". ");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }
    }

}

