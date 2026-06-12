package main.java.interview;

import java.util.HashMap;
import java.util.Map;

public class WordMapProcessor {
  Map<String, String> wordMap = new HashMap<>();
  Map<Character, Integer> keybadMap = new HashMap<>();

  public WordMapProcessor() {
    keybadMap.put('a', 2);
    keybadMap.put('b', 2);
    keybadMap.put('c', 2);
    keybadMap.put('d', 3);
    keybadMap.put('e', 3);
    keybadMap.put('f', 3);
    keybadMap.put('g', 4);
    keybadMap.put('h', 4);
    keybadMap.put('i', 4);
    keybadMap.put('j', 5);
    keybadMap.put('k', 6);
    keybadMap.put('l', 5);
    keybadMap.put('m', 6);
    keybadMap.put('n', 6);
    keybadMap.put('o', 6);
    keybadMap.put('p', 7);
    keybadMap.put('q', 7);
    keybadMap.put('r', 7);
    keybadMap.put('s', 7);
    keybadMap.put('t', 8);
    keybadMap.put('u', 8);
    keybadMap.put('v', 8);
    keybadMap.put('w', 9);
    keybadMap.put('x', 9);
    keybadMap.put('y', 9);
    keybadMap.put('z', 9);
  }

  public boolean addWord(String word) {
    // regex tovalidate the correct format we want

    String numberString = wordToNumber(word);
    wordMap.put(word, numberString);
    return true;
  }

  public boolean removeWord(String word) {
    return true;
  }

  private String wordToNumber(String word) {
    StringBuilder numberFormat = new StringBuilder();
    // word to number format

    for (char letter : word.toLowerCase().toCharArray()) {
      numberFormat.append(keybadMap.get(letter));
    }

    return numberFormat.toString();
  }

  public String matchWord(String numberString) {
    for (Map.Entry<String, String> entry : wordMap.entrySet()) {
      if (entry.getValue().equals(numberString)) {
        return entry.getKey();
      }
    }
    return "";
  }
}
