package main.java.miscellaneous;

/*Write a function that takes a string as input, and returns a boolean as output.

1. It should return a true, if the input string can be re-arranged into a palindrome.
2. It should return a false otherwise.

Examples:
input valid arrange output
1. aabb -> abba, baab -> True, ababababa - True
2. aab -> aba -> True
3. hari -> ---- -> False
a=5
b=3

*/

import java.util.HashMap;
import java.util.Map;

public class StringPalindrome {

  public static void main(String[] args) {

    String str = "hari";
    boolean result = isPalindrome(str);
    System.out.println(result);
  }

  private static boolean isPalindrome(String str) {

    boolean result = true;

    if (str == null) return false;

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(str.charAt(i))) map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
      else map.put(str.charAt(i), 1);
    }

    int count = 0;
    for (Map.Entry<Character, Integer> element : map.entrySet()) {
      if (element.getValue() % 2 == 1) count++;

      if (count > 1) {
        result = false;
        break;
      }
    }

    return result;
  }
}
