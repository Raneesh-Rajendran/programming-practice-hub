package main.java.miscellaneous;

/*
[-3, 2, 5, 6, -10, 9]
ans = [2, 5, 6]

[-3, 2]
ans = [2]

[-3, 2]
ans = [2]

n = 2
ans = -3 -1
sum = -3 -1
 */

public class MaximumSumSubArray {
  public static void main(String[] args) {
    int[] array = new int[] {-3, 2, 5, 6, -10, 9};
    System.out.println(maximumSum(array));
  }

  public static int maximumSum(int[] array) {
    int n = array.length;
    int ans = array[0];
    int sum = array[0];
    int i = 0, j = 1;
    while (j < n) {
      sum += array[j];
      if (sum > ans) {
        ans = Math.max(sum, ans);
        j++;
      } else {
        sum -= array[i];
        ans = Math.max(sum, ans);
        i++;
      }
      if (j >= n) {
        j--;
        i++;
      }
    }
    return ans;
  }
}
