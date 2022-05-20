package main;

import java.util.ArrayList;
import java.util.List;

// If a character is an ASCII letter we're gonna move it 3 places right expect the last 3 character, them we're gonna move 23 places left.
// User can also enter number of places they want to move letter. This number can't be bigger than 25 and also can't be negative.
// For special character we are using next scheme:
// periods, "commas", "double quotation marks", "colons", "hyphen", "exclamation points", "question marks", and spaces
// periods  = question marks  -> . = ?
// question marks = colons -> ? = :
// colons = hyphen -> : = -
// hyphen = exclamation points -> - = !
// exclamation points= commas -> ! = ,
// commas =  double quotation marks -> , = "
// double quotation marks = spaces -> " =
// spaces = periods ->  = .


public class CaesarCipher implements Encryption, Decryption {
    List<String> lines;

    public CaesarCipher(List<String> lines) {
        this.lines = lines;
    }

    boolean smallCase(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }

    boolean capitalCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }


    @Override
    public List<String> encrypting(List<String> lines, int shift) {
        List<String> encrypted = new ArrayList<>();
        int number = 'a';
        for (String line : lines) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if ((smallCase(ch) && 'z' - ch <= shift - 1 && 'z' - ch >= 0) || (capitalCase(ch) && 'Z' - ch <= shift - 1 && 'Z' - ch >= 0)) {
                    ch -= 23;
                } else if ((smallCase(ch) && 'z' - ch > 2 && 'z' - ch < 26) || (capitalCase(ch) && 'Z' - ch > 2 && 'Z' - ch < 26)) {
                    ch += 3;
                } else {
                    switch (ch) {
                        case '.':
                            ch = '?';
                            break;
                        case '?':
                            ch = ':';
                            break;
                        case ':':
                            ch = '-';
                            break;
                        case '-':
                            ch = '!';
                            break;
                        case '!':
                            ch = ',';
                            break;
                        case ',':
                            ch = '\"';
                            break;
                        case '\"':
                            ch = ' ';
                            break;
                        case ' ':
                            ch = '.';
                            break;
                        default:
                            continue;
                    }
                }
                builder.append(ch);
            }
            encrypted.add(builder.toString());
        }
        return encrypted;
    }

    @Override
    public List<String> encrypting(List<String> lines) {
        List<String> encrypted = new ArrayList<>();
        for (String line : lines) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if ((smallCase(ch) && 'z' - ch <= 2 && 'z' - ch >= 0) || (capitalCase(ch) && 'Z' - ch <= 2 && 'Z' - ch >= 0)) {
                    ch -= 23;
                } else if ((smallCase(ch) && 'z' - ch > 2 && 'z' - ch < 26) || (capitalCase(ch) && 'Z' - ch > 2 && 'Z' - ch < 26)) {
                    ch += 3;
                } else {
                    switch (ch) {
                        case '.':
                            ch = '?';
                            break;
                        case '?':
                            ch = ':';
                            break;
                        case ':':
                            ch = '-';
                            break;
                        case '-':
                            ch = '!';
                            break;
                        case '!':
                            ch = ',';
                            break;
                        case ',':
                            ch = '\"';
                            break;
                        case '\"':
                            ch = ' ';
                            break;
                        case ' ':
                            ch = '.';
                            break;
                        default:
                            continue;
                    }
                }
                builder.append(ch);
            }
            encrypted.add(builder.toString());
        }
        return encrypted;
    }

    @Override
    public List<String> decrypting(List<String> lines) {
        List<String> decrypted = new ArrayList<>();
        for (String line : lines) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if ((smallCase(ch) && 'z' - ch >= 23 && 'z' - ch < 26) || (capitalCase(ch) && 'Z' - ch >= 23 && 'Z' - ch < 26)) {
                    ch += 23;
                } else if ((smallCase(ch) && 'z' - ch < 23 && 'z' - ch >= 0) || (capitalCase(ch) && 'Z' - ch < 23 && 'Z' - ch >= 0)) {
                    ch -= 3;
                } else {
                    switch (ch) {
                        case '?':
                            ch = '.';
                            break;
                        case ':':
                            ch = '?';
                            break;
                        case '-':
                            ch = ':';
                            break;
                        case '!':
                            ch = '-';
                            break;
                        case ',':
                            ch = '!';
                            break;
                        case '\"':
                            ch = ',';
                            break;
                        case ' ':
                            ch = '\"';
                            break;
                        case '.':
                            ch = ' ';
                            break;
                        default:
                            continue;
                    }
                }
                builder.append(ch);
            }
            decrypted.add(builder.toString());
        }
        return decrypted;
    }
}
