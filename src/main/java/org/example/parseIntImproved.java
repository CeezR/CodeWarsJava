package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class parseIntImproved {
    private static final Map<String, Integer> NUM_WORDS = new HashMap<>();
    static {
        NUM_WORDS.put("zero", 0);
        NUM_WORDS.put("one", 1);
        NUM_WORDS.put("two", 2);
        NUM_WORDS.put("three", 3);
        NUM_WORDS.put("four", 4);
        NUM_WORDS.put("five", 5);
        NUM_WORDS.put("six", 6);
        NUM_WORDS.put("seven", 7);
        NUM_WORDS.put("eight", 8);
        NUM_WORDS.put("nine", 9);
        NUM_WORDS.put("ten", 10);
        NUM_WORDS.put("eleven", 11);
        NUM_WORDS.put("twelve", 12);
        NUM_WORDS.put("thirteen", 13);
        NUM_WORDS.put("fourteen", 14);
        NUM_WORDS.put("fifteen", 15);
        NUM_WORDS.put("sixteen", 16);
        NUM_WORDS.put("seventeen", 17);
        NUM_WORDS.put("eighteen", 18);
        NUM_WORDS.put("nineteen", 19);
        NUM_WORDS.put("twenty", 20);
        NUM_WORDS.put("thirty", 30);
        NUM_WORDS.put("forty", 40);
        NUM_WORDS.put("fifty", 50);
        NUM_WORDS.put("sixty", 60);
        NUM_WORDS.put("seventy", 70);
        NUM_WORDS.put("eighty", 80);
        NUM_WORDS.put("ninety", 90);
        NUM_WORDS.put("hundred", 100);
        NUM_WORDS.put("thousand", 1000);
        NUM_WORDS.put("million", 1000000);
        NUM_WORDS.put("billion", 1000000000);
    }

    public static int wordsToNumber(String words) {
        String[] tokens = words.replaceAll(" and", "").split("\\s+");
        int result = 0;
        int partialResult = 0;

        for (String token : tokens) {
            Integer number;
            if(token.contains("-")) {
                String[] twoDigitNumber = Arrays.stream(token.split("-")).toArray(String[]::new);
                number = NUM_WORDS.get(twoDigitNumber[0]) + NUM_WORDS.get(twoDigitNumber[1]);
                System.out.println(number);
            } else {
                number = NUM_WORDS.get(token);
            }

            if (number >= 1000) {
                result += partialResult * number;
                partialResult = 0;
            } else if (number >= 100) {
                partialResult *= number;
            } else {
                partialResult += number;
            }
        }

        return result + partialResult;
    }


    public static void main(String[] args) {
        String words = "seven hundred eighty-three thousand nine hundred nineteen";
        int number = wordsToNumber(words);
        System.out.println(number);  // Output: 783919
    }


}
