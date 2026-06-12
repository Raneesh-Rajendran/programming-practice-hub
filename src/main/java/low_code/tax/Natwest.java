package main.java.low_code.tax;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Natwest {

  public static void main(String[] args) {
    String s1 = "spots";
    String s2 = "potsf";
    System.out.println("Is Anagram : " + isAnagram(s1, s2));
  }

  public static boolean isAnagram(String s1, String s2) {
    Map<Character, Integer> s1Count = new HashMap<>();
    Map<Character, Integer> s2Count = new HashMap<>();

    for (Character ckr : s1.toCharArray()) {
      s1Count.put(ckr, s1Count.getOrDefault(ckr, 0) + 1);
    }

    for (Character ckr : s2.toCharArray()) {
      s2Count.put(ckr, s2Count.getOrDefault(ckr, 0) + 1);
    }

    if (s1Count.size() == s2Count.size()) {
      for (Map.Entry<Character, Integer> elem : s1Count.entrySet()) {
        if (!Objects.equals(elem.getValue(), s2Count.get(elem.getKey()))) {
          return false;
        }
      }
    } else {
      return false;
    }
    return true;
  }
}
