package main.java.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

  public static void main(String[] args) {
    String str = "abc";
    List<String> result = permuteString(str.toCharArray(), 0, new ArrayList<>());
    result.forEach(System.out::println);
  }

  public static List<String> permuteString(char[] charArr, int start, List<String> result) {

    if (start == charArr.length - 1) result.add(new String(charArr));
    else {
      for (int i = start; i < charArr.length; i++) {
        swap(charArr, start, i);
        permuteString(charArr, start + 1, result);
        swap(charArr, start, i); // backtrack
      }
    }
    return result;
  }

  private static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
