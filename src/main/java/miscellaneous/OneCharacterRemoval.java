package main.java.miscellaneous;

import java.util.*;

/*
Write a function checking that the given string is valid. We consider a string
to be valid if all the characters of the string have exactly the same frequency.

Examples:
"aabbcc" is a valid string
"aabbccc" is an invalid string

Check if the string is valid as it is (same condition as before) or if one character
at one position can be removed from the string so it will become valid.

"aabbccc" is an valid string => remove 1 c => "aabbcc" => valid
*/
public class OneCharacterRemoval {

  public static void main(String[] args) {
    System.out.println(stringValidity("aabbccc"));
  }

  public static boolean stringValidity(String str) {
    if (str == null || str.isEmpty()) return false;

    Map<Character, Integer> charCount = new HashMap<>();
    for (Character c : str.toCharArray()) {
      if (charCount.containsKey(c)) charCount.put(c, charCount.get(c) + 1);
      else charCount.put(c, 1);
    }
    // 2 2 3
    // 3 2 2
    // 2 2 2
    // 2 3 4
    // 2 2 2 3 3 3 3 3
    Set<Integer> countSet = new HashSet<>();
    for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
      if (countSet.size() > 2) return false;

      if (countSet.contains(entry.getValue()) && countSet.size() == 2) return false;

      countSet.add(entry.getValue());
    }

    return true;
  }
}

// Tests
// "aabbcc" -> true
// null -> false
// "" -> false
// "aabbccc" -> false
// "ababab" -> true
// "abdca" -> false
// "abd abd" -> false
// "!@@!" -> true
// "ab ab " -> true
// "a1a1"` -> true
// "1234" -> false
// "a2b3" -> false
