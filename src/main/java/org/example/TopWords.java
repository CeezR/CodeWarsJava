package org.example;

import java.util.*;
import java.util.Collections;

public class TopWords {

  public static void main(String[] args) {

  }

  public static List<String> top3(String s) {
    // Your code here
    Map<String, Integer> wordFrequency = new HashMap<String, Integer>();

    String[] words = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

    for (String word : words) {
      if (wordFrequency.containsKey(word)) {
        int count = wordFrequency.get(word);
        wordFrequency.put(word, count + 1);
      } else {
        wordFrequency.put(word, 1);
      }
    }
    /*
    // sort by frequency count and store in a string array
    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());
    String[] top3 =  sortedList
            .stream()
            .sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) ->  e2.getValue().compareTo(e1.getValue()))
            .collect()

     */
    String[] sortedWords = new String[sortedList.size()];
    for (int i = 0; i < sortedList.size(); i++) {
      sortedWords[i] = sortedList.get(i).getKey();
    }

    System.out.println(Arrays.toString(sortedWords));



    return null;
  }
}
