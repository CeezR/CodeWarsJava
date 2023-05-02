package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StopgninnipSMysdroW {
    public static void main(String[] args) {
        System.out.println(spinWords( "Hey fellow warriors" ));
    }
    public static String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(StringBuilder::new)
                .map(a -> a.length() >= 5 ? a.reverse() : a)
                .collect(Collectors.joining(" "));
    }
}
