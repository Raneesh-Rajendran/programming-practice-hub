package main.java.miscellaneous;

import java.util.*;
import java.util.stream.Collectors;

/*
You are given an integer array  of size and an integer. Your task is to
return the list of all pairs of elements such that each sum of elements of each pair
equals.
Note:
Each pair should be sorted i.e the first value should be less than or equals to the
second value.
Return the list of pairs sorted in non-decreasing order of their first value. In case if
two pairs have the same first value, the pair with a smaller second value should
come first.
Sample Input 1:
5 5
1 2 3 4 5
Sample Output 1:
1 4
2 3
 */
public class SumPairsSorted {

  public static void main(String[] args) {
    int[] array = {1, 2, 2, 1, 2};
    List<List<Integer>> pairs = targetSumPairs(array, 4);

    pairs.sort(Comparator.comparingInt((List<Integer> o) -> o.getFirst()).thenComparingInt(List::getLast));

    pairs.stream()
        .map(list -> list.stream().map(String::valueOf).collect(Collectors.joining(",")))
        .forEach(System.out::println);
  }

  public static List<List<Integer>> targetSumPairs(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Set<String> seenPairs = new HashSet<>();
    Set<Integer> elementSet = new HashSet<>();

    for (int element : arr) {
      int second = target - element;
      if (elementSet.contains(second)) {
        int min = Math.min(element, second);
        int max = Math.max(element, second);
        String key = min + ":" + max;

        if (!seenPairs.contains(key)) {
          result.add(List.of(min, max));
          seenPairs.add(key);
        }
      }
      elementSet.add(element);
    }
    return result;
  }
}
