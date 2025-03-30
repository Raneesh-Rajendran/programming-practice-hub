package main.java.miscellaneous;

import java.util.List;

public class MinSubsequenceSum {
  public static long getMinimumSum(List<Integer> arr) {
    int n = arr.size();
    int[] leftMin = new int[n];
    int[] rightMin = new int[n];

    // Initialize leftMin array
    leftMin[0] = Integer.MAX_VALUE; // There's no element to the left of the first element
    for (int i = 1; i < n; i++) {
      leftMin[i] = Math.min(leftMin[i - 1], arr.get(i - 1));
    }

    // Initialize rightMin array
    rightMin[n - 1] = Integer.MAX_VALUE; // There's no element to the right of the last element
    for (int i = n - 2; i >= 0; i--) {
      rightMin[i] = Math.min(rightMin[i + 1], arr.get(i + 1));
    }

    // Find the optimal subsequence
    long minSum = Long.MAX_VALUE;
    for (int i = 1; i < n - 2; i++) {
      // Ensure the current element is greater than the minimums on both sides
      if (arr.get(i) > leftMin[i] && arr.get(i) > rightMin[i]) {
        long sum = (long) leftMin[i] + (long) arr.get(i) + (long) rightMin[i];
        minSum = Math.min(minSum, sum);
      }
    }

    return (minSum == Long.MAX_VALUE) ? -1 : minSum;
  }

  public static void main(String[] args) {
    List<Integer> arr = List.of(3, 4, 5, 1, 2, 3, 1);
    System.out.println(getMinimumSum(arr)); // Output should be 4
  }
}
