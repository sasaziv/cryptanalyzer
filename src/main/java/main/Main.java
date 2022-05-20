package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> lines;
        lines = ReadTxt.readTxt("src/files/test.txt");
        CaesarCipher caesarCipher = new CaesarCipher(lines);

        System.out.println("Original:");
        System.out.println();
        PrintTxt.printTxt("src/files/test.txt");

        //Encryption test
        System.out.println("Encryption:");
        System.out.println();
        lines = caesarCipher.encrypting(lines, 3);
        WriteTxt.writeFile(lines, "src/files/testEnc.txt");
        PrintTxt.printTxt("src/files/testEnc.txt");

        //Decryption test
        System.out.println("Decription:");
        System.out.println();
        lines = ReadTxt.readTxt("src/files/testEnc.txt");
        lines = caesarCipher.decrypting(lines);
        WriteTxt.writeFile(lines, "src/files/test.txt");
        PrintTxt.printTxt("src/files/test.txt");


    }
}
