package main.java.miscellaneous;

public class ArraySorter {
  public static void sortPositiveAndZeroFirst(int[] arr) {
    int n = arr.length;
    int firstNonNegative = -1; // Initialize to an invalid index

    // Find the first non-negative number (positive or zero)
    for (int i = 0; i < n; i++) {
      if (arr[i] >= 0) {
        firstNonNegative = i;
        break;
      }
    }

    if (firstNonNegative == -1) return; // All numbers are negative

    for (int i = firstNonNegative + 1; i < n; i++) {
      if (arr[i] >= 0) {
        // Swap with the first negative number after the first non-negative number
        int j = i;
        while (j > firstNonNegative && arr[j - 1] < 0) {
          swap(arr, j, j - 1);
          j--;
        }
        firstNonNegative++;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Main method for testing
  public static void main(String[] args) {
    int[] arr = {-1, -3, -4, 2, 8, 0, -2};
    sortPositiveAndZeroFirst(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
