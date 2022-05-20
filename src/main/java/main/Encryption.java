package main;

import java.util.List;

public interface Encryption {
    List<String> encrypting(List<String> strings);
    List<String> encrypting(List<String> strings, int n);
}
