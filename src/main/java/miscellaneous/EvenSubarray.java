package main.java.miscellaneous;

import java.util.*;

public class EvenSubarray {

  // Iterative approach
  public static int evenSubarrayIterative(List<Integer> numbers, int k) {
    Set<List<Integer>> uniqueCombinations = new HashSet<>();

    for (int i = 0; i < numbers.size(); i++) {
      int oddElements = 0;
      for (int j = i; j < numbers.size(); j++) {
        if (numbers.get(j) % 2 != 0) {
          oddElements++;
        }

        if (oddElements > k) {
          break;
        } else {
          uniqueCombinations.add(numbers.subList(i, j + 1));
        }
      }
    }

    uniqueCombinations.forEach(System.out::println);
    return uniqueCombinations.size();
  }

  // Recursive approach
  public static int evenSubarrayRecursive(List<Integer> numbers, int k) {
    Set<List<Integer>> uniqueCombinations = new HashSet<>();

    for (int i = 0; i < numbers.size(); i++) {
      backtrack(i, new ArrayList<>(), 0, numbers, k, uniqueCombinations);
    }

    return uniqueCombinations.size();
  }

  private static void backtrack(
      int index,
      List<Integer> path,
      int oddCount,
      List<Integer> numbers,
      int k,
      Set<List<Integer>> result) {
    if (oddCount > k || index >= numbers.size()) {
      return;
    }

    int current = numbers.get(index);
    path.add(current);

    if (current % 2 != 0) {
      oddCount++;
    }

    if (oddCount <= k) {
      result.add(new ArrayList<>(path));
      backtrack(index + 1, path, oddCount, numbers, k, result);
    }

    path.remove(path.size() - 1); // backtrack
  }

  public static void main(String[] args) {
    // Test input
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int k = 1;

    int iterativeResult = EvenSubarray.evenSubarrayIterative(numbers, k);
    int recursiveResult = EvenSubarray.evenSubarrayRecursive(numbers, k);

    System.out.println("Iterative Result: " + iterativeResult);
    System.out.println("Recursive Result: " + recursiveResult);
  }
}
