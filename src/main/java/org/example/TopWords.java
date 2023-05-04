package org.example;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TopWords {

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

    return null;
  }
}
