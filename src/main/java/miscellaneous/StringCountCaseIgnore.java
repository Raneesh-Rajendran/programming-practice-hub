package main.java.miscellaneous;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCountCaseIgnore {

  public static void main(String[] args) {

    String str = "Hi hello HOW wHy who hI HeLLO how Why user. User";
    // str.replaceAll("[a-zA-Z]");
    String[] words = str.split(" ");
    Map<String, Integer> map = new LinkedHashMap<>();
    for (String word : words) {
      String wordLowerCase = word.toLowerCase();
      if (map.containsKey(wordLowerCase)) map.put(word, map.get(wordLowerCase) + 1);
      else map.put(wordLowerCase, 1);
    }

    System.out.println(map);
  }
}
