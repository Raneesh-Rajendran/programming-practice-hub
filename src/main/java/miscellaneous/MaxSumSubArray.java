package main.java.miscellaneous;

public class MaxSumSubArray {
  public static int maxSumSubArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int num : arr) {
      currentSum = Math.max(num, currentSum + num);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = {-3, 2, 5, 6, -10, 9};
    System.out.println("Maximum sum formed by any sub array: " + maxSumSubArray(arr));
  }
}
