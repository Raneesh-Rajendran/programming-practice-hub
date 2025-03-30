package main.java.miscellaneous;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change
 * it to any other uppercase English character. You can perform this operation at most k times.
 *
 * <p>Return the length of the longest substring containing the same letter you can get after
 * performing the above operations.
 *
 * <p>Examples:
 *
 * <p>Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's with two 'B's or vice
 * versa.
 *
 * <p>Example 2:
 *
 * <p>Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A' in the middle with 'B'
 * and form "AABBBBA". The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * <p>Input: s = "DBBDDB", k = 2 Output: = 5
 *
 * <p>Input: s = "AAB", k = 2 Output: 3
 *
 * <p>Input: s = "AABAAAAAC", k = 2 Output: 9
 *
 * <p>Input: s = "AAABCCCDEEE", k = 2 Output: 5
 */
import java.util.HashMap;

public class KReplaceLongSubstring {

  static int maximumFrequency(String subString, int k) {
    int max = 0;
    HashMap<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < subString.length(); i++) {
      char ch = subString.charAt(i);
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
      max = Math.max(max, frequency.get(subString.charAt(i)));
    }
    return max;
  }

  static int characterReplacement(String input, int k) {
    // write your code here
    int ans = 0;
    int i = 0, j = 0;
    int n = input.length();
    while (j < n) {
      String subString = input.substring(i, j + 1);
      int max = maximumFrequency(subString, k);
      int length = j - i + 1;
      if ((length - max) <= k) {
        ans = Math.max(ans, length);
        j++;
      } else {
        i++;
      }
    }
    return ans;
  }

  static int characterReplacementSW(String s, int k) {
    HashMap<Character, Integer> count = new HashMap<>();
    int maxCount = 0;
    int maxLength = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      char currentChar = s.charAt(right);
      count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);
      maxCount = Math.max(maxCount, count.get(currentChar));

      while (right - left + 1 - maxCount > k) {
        count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    int length = characterReplacementSW("ABAB", 2);
    System.out.println(length);
  }
}
