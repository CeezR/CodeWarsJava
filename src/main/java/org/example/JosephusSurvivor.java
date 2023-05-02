package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusSurvivor {
    public static void main(String[] args) {
        System.out.println(josephusSurvivor(11,19));
    }
    public static int josephusSurvivor(final int n, final int k) {
        // Generate List of n where n counts up from 1 -> n
        List<Integer> survivers = new ArrayList<>(IntStream.rangeClosed(1, n).boxed().toList());
        // While loop check for size of list is more then 1
        int eliminationIndex = -1;
        while (survivers.size() > 1) {

            for(int i = 0; i < k; i++) {
                eliminationIndex = eliminationIndex == (survivers.size() - 1) ? 0 : (eliminationIndex + 1);
                //System.out.println(eliminationIndex);
            }

            //System.out.println(survivers.toString());
            survivers.remove(eliminationIndex);
            eliminationIndex = eliminationIndex == 0 ? (survivers.size() -1) : (eliminationIndex - 1);
            //System.out.println(survivers.toString());
        }
        // return index 0 of list
        return survivers.get(0);
    }
}
