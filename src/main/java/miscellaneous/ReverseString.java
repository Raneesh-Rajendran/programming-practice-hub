package main.java.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

  public static void main(String[] args) {
    String name = "Raneesh";
    int[] array = new int[] {12, 3, 4, 9, 6, 1};
    triplets(array, 24).forEach(e -> System.out.println(e[0] + " " + e[1] + " " + e[2]));
  }

  public static List<int[]> triplets(int[] array, int sum) {
    List<int[]> result = new ArrayList<>();
    Arrays.sort(array);
    for (int i = 0; i < array.length - 2; i++) {
      int j = i + 1, k = array.length - 1;
      while (j < k) {
        int tempSum = array[i] + array[j] + array[k];
        if (tempSum == sum) {
          result.add(new int[] {array[i], array[j], array[k]});
          while (j < k && array[j] == array[j + 1]) j++;
          while (j < k && array[k] == array[k - 1]) k--;
          j++;
          k--;
        } else if (tempSum < sum) {
          j++;
        } else {
          k--;
        }
      }
    }
    return result;
  }

  public String reverseString(String input) {
    return Stream.iterate(input.length() - 1, i -> i - 1)
        .limit(input.length())
        .map(input::charAt)
        .map(Object::toString)
        .collect(Collectors.joining());
  }
}
