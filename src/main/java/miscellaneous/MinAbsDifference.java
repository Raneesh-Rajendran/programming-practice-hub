package main.java.miscellaneous;

import java.util.Arrays;

public class MinAbsDifference {

  // function to find the sum of
  // minimum absolute difference
  static int sumOfMinAbsDifferences(int[] arr, int n) {

    // sort the given array
    Arrays.sort(arr);

    // initialize sum
    int sum = 0;

    // min absolute difference for
    // the 1st array element
    sum += Math.abs(arr[0] - arr[1]);

    // min absolute difference for
    // the last array element
    sum += Math.abs(arr[n - 1] - arr[n - 2]);

    // find min absolute difference for
    // rest of the array elements and
    // add them to sum
    for (int i = 1; i < n - 1; i++)
      sum += Math.min(Math.abs(arr[i] - arr[i - 1]), Math.abs(arr[i] - arr[i + 1]));

    // required sum
    return sum;
  }

  // Driver code
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5, 1};
    int n = arr.length;

    System.out.println("Sum = " + sumOfMinAbsDifferences(arr, n));
  }
}
