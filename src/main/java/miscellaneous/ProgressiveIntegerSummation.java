package main.java.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class ProgressiveIntegerSummation {

  public static void main(String[] args) {
    // System.out.println(summation(new int[]{1,6,8,5,9,4,7,2,10,10,10,10,10,10,10,10,10}));
    System.out.println(
        optimizedSummation(new int[] {1, 6, 8, 5, 9, 4, 7, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
  }

  private static List<Integer> summation(int[] arr) {
    int n = arr.length;
    List<Integer> result = new ArrayList<>();
    int counter = 0;
    for (int i = 0; i < n && counter < n; i++) {
      int sum = 0;
      for (int j = 0; j <= i; j++) {
        if (counter < n) {
          sum += arr[counter];
          counter++;
        } else break;
      }
      result.add(sum);
      if (counter > n) break;
    }
    return result;
  }

  private static List<Integer> optimizedSummation(int[] arr) {
    List<Integer> result = new ArrayList<>();
    int runningSum = 0;
    int nextCount = 1;
    int count = 0; // this keeps track of how many numbers we have added to the current running sum

    for (int num : arr) {
      runningSum += num;
      count++;

      // When we've added 'nextCount' numbers, we can put the runningSum to the result.
      if (count == nextCount) {
        result.add(runningSum);
        runningSum = 0; // Reset running sum for the next group of numbers
        nextCount++; // Increment the count for the next group
        count = 0; // Reset the count
      }
    }

    // If the last group has fewer numbers than expected but non-zero, add it as well
    if (count > 0) {
      result.add(runningSum);
    }

    return result;
  }
}
