package org.example;

import javax.management.StringValueExp;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;


public class parseIntReloaded {

    public static void main(String[] args) {
        //parseInt("1022313"); //"one million twenty-two thousand three hundred thirteen"
        System.out.println(parseInt("zero"));
        System.out.println(parseInt("one"));
        System.out.println(parseInt("twenty"));
        //System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
        System.out.println(parseInt("nine thousand nine hundred sixty-three"));
        //System.out.println(String.valueOf(((((7) * 100) + 83) * 1000) + (9) * 100 + 19));
    }
    private static final List<String> tensNames = Arrays.asList(
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    );

    private static final List<String> numNames = Arrays.asList(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    );

    private static final Map<String, Integer> stringValueMap = Map.of("million", 1_000_000, "thousand", 1_000, "hundred", 100, "", 1);
    private static final List<String> unitsString = Arrays.asList("million","thousand","hundred");

    //public static parseUnitNumberArray()
    //[[seven], hundred, eighty-three], thousand, [nine], hundred, [nineteen]]
    public static ArrayList<Integer> parseIntFromName(String[] ar) {
        ArrayList<Integer> intNumbers = new ArrayList<>();
        for(String number : ar) {
            if(numNames.contains(number)) {
                intNumbers.add(numNames.indexOf(number));
            } else if(tensNames.contains(number)) {
                intNumbers.add(tensNames.indexOf(number) * 10);
            } else if(unitsString.contains(number)) {
                intNumbers.add(stringValueMap.get(number));
            } else {
                String[] tensAndSingle = number.split("-");
                intNumbers.add(Integer.parseInt(tensNames.indexOf(tensAndSingle[0]) + "" + numNames.indexOf(tensAndSingle[1])));
            }
        }
        return intNumbers;
    }

    //public static int[] findLargestUnit(ArrayList)

    public static int  parseInt(String numStr) {
        ArrayList<String> parsedArray = Arrays.stream(numStr.split(" ")).collect(Collectors.toCollection(ArrayList::new));
        parsedArray.remove("and");
        ArrayList<Integer> intList = parseIntFromName(parsedArray.toArray(String[]::new));
        System.out.println(intList.toString());

        if(intList.size() == 1)
            return intList.get(0);


        // Multiply all 100 with left value
        while(intList.contains(100)) {
            int indexOfUnit = intList.indexOf(100);
            int leftValue;
            if(intList.get(indexOfUnit - 1) == 1000)
                break;
            if(indexOfUnit == 0)
                break;
            if(indexOfUnit != -1) {
                leftValue = intList.get(indexOfUnit - 1);
                intList.set(indexOfUnit, 100 * leftValue);
                intList.remove(indexOfUnit - 1);

            }
            System.out.println(intList.toString());

        }
        System.out.println("Sum ALL");
        // Sum all non unit
        for(int i = 0; i < intList.size(); i++) {
            if(i == intList.size() - 1)
                break;
            if(intList.get(i) != 1000 && intList.get(i) != 100) {
                if(intList.get(i + 1) != 1000 && intList.get(i) != 100) {
                    int sum = intList.get(i) + intList.get(i + 1);
                    intList.set(i, sum);
                    intList.remove(i + 1);
                }
            }
            System.out.println(intList.toString());
        }
        System.out.println("Multiply all 1000");
        // Multiply all 1000 with left value
        while(intList.contains(1000)) {
            int indexOfUnit = intList.indexOf(1000);
            int leftValue;
            if(indexOfUnit == 0)
                break;
            if(indexOfUnit != -1) {
                leftValue = intList.get(indexOfUnit - 1);
                intList.set(indexOfUnit, 1000 * leftValue);
                intList.remove(intList.get(indexOfUnit - 1));

            }
            System.out.println(intList.toString());

        }


        // Add all non unit value with non unit left value
        // Mutliple all 1000 with left value

        // [7, 100, 83, 1000, 9, 100, 19]
        // [700, 83, 1000, 900, 19]
        // [783, 1000, 919]
        // [783000, 919]
        // [783917]
        // "seven hundred eighty-three thousand nine hundred and nineteen"
        // [Multiply(Add(Multiply(7,100), 83)), 1000), Multiply(9, 100), 19]

        return intList.stream().mapToInt(Integer::intValue).sum();

        /*
        for(String unit : unitsString) {
            int indexOfUnit = parsedArray.indexOf(unit);
            if(indexOfUnit != -1) {
                String[] unitNumber = parsedArray.subList(0, indexOfUnit).toArray(String[]::new);
                parsedArray.subList(0, indexOfUnit+ 1).clear();
                unitValueMap.put(stingValueMap.get(unit), unitNumber);
            }
        }
        if(parsedArray.size() > 0) {
            unitValueMap.put(1, parsedArray.toArray(String[]::new));
        }

        for(Map.Entry<Integer, String[]> entry : unitValueMap.entrySet()) {
            int unitKey = entry.getKey();
            String[] numbers = entry.getValue();

            System.out.println(unitKey + " " + Arrays.toString(numbers));

            for(String number : numbers) {

                if(numNames.contains(number)) {
                    System.out.println(numNames.indexOf(number));
                } else if(tensNames.contains(number)) {
                    System.out.println(tensNames.indexOf(number));
                } else if(unitsString.contains(number)) {
                    System.out.println(stingValueMap.get(number));
                } else {
                    String[] tensAndSingle = number.split("-");
                    System.out.println(tensNames.indexOf(tensAndSingle[0]) + "" + numNames.indexOf(tensAndSingle[1]));
                }
            }
                    }
         */

    }



    public static String parseString(String numStr) {
        // Your code here!
        int remainder = Integer.parseInt(numStr);
        int[] parsedNumbers = {1_000_000, 1000, 100, 10};
        ArrayList<String> parsedNumbersStringefied = new ArrayList<>();
        for(int i = 0; i < parsedNumbers.length; i++) {
            int divider = parsedNumbers[i];
            parsedNumbers[i] = i == parsedNumbers.length - 1 ? remainder : remainder / divider;
            if(parsedNumbers[i] != 0) {
                parsedNumbersStringefied.add(parseintToString(parsedNumbers[i], i));
            }
            remainder %= divider;
        }

        System.out.println(parsedNumbersStringefied.toString());

        return "-1";
    }

    public static String parseintToString(int number, int digit) {
        StringBuilder s = new StringBuilder();

        if(number < 20) {
            s.append(numNames.get(number));
        } else {
            int firstDigit = number / 10;
            int secondDigit = number % 10;
            if(secondDigit == 0) {
                s.append(tensNames.get(firstDigit));
            } else
                s.append(tensNames.get(firstDigit) + "-" + numNames.get(secondDigit));

        }

        switch (digit) {
            case 0:
                s.append(" milion");
                break;
            case 1:
                s.append(" thousand");
                break;
            case 2:
                s.append(" hundred");
                break;
            case 3:
                s.indexOf("and ", 0);
                break;
        }

        return s.toString();

    }
}
