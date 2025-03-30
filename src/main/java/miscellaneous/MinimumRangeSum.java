package main.java.miscellaneous;

public class MinimumRangeSum {
  public static void main(String[] args) {

    int[] array = {1, 2, 4, 5, 1};

    /*int result = 0;
    for (int i = 0; i < array.length; i++) {

        int  difference = 0;
        difference = Math.abs(Arrays.stream(Arrays.copyOfRange(array, 0 , i)).sum()
                - Arrays.stream(Arrays.copyOfRange(array, i , array.length)).sum());
        if(i==0){
            result = difference;
            continue;
        }

        if(result > difference)
            result = difference;
    }
    System.out.println(result);

    System.out.println(findElement(array, array.length));*/

    System.out.println(minimumDiffRangeSum(array, array.length));
  }

  static int findElement(int[] arr, int n) {
    int[] prefixSum = new int[n];
    prefixSum[0] = arr[0];
    for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + arr[i];

    int[] suffixSum = new int[n];
    suffixSum[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) suffixSum[i] = suffixSum[i + 1] + arr[i];

    int result = Math.abs(prefixSum[0] - suffixSum[0]);
    for (int i = 1; i < n - 1; i++)
      if (result < Math.abs(prefixSum[i] - suffixSum[i]))
        result = Math.abs(prefixSum[i] - suffixSum[i]);

    return result;
  }

  static int minimumDiffRangeSum(int[] arr, int N) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += arr[i];
    }

    int left = 0, right = sum, result = Math.abs((left + arr[0]) - (right - arr[0]));

    for (int i = 0; i < N; i++) {
      left += arr[i];
      right -= arr[i];
      int difference = Math.abs(left - right);
      if (difference < result) result = difference;
    }
    return result;
  }
}
