package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimplePigLatin {
    public String pigIt(String str) {

        StringBuilder[] stringBuilder = Arrays.stream(str.split(" "))
                .map(StringBuilder::new).toArray(StringBuilder[]::new);

        for(StringBuilder s : stringBuilder) {
            if(s.toString().matches("[a-zA-Z]+")) {
                // Valid Word
                s.append(s.charAt(0));
                s.deleteCharAt(0);
                s.append("ay");
            } else
                continue;

        }

        return String.join(" ", stringBuilder);
    }

    public String pigItImproved(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }
}
