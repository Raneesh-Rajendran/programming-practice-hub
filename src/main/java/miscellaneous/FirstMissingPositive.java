package main.java.miscellaneous;

public class FirstMissingPositive {

  public static void main(String[] args) {
    int[] array = new int[] {0, -1, 1, 2, 3, 4, 6};
    System.out.println(firstMissingPositive(array));
  }

  public static int firstMissingPositive(int[] A) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
      if (A[i] <= 0 || A[i] > n || A[i] == A[A[i] - 1]) continue;
      swap(A, i, A[i] - 1);
      i--;
    }
    for (int i = 0; i < n; i++) {
      if (i + 1 != A[i]) return i + 1;
    }
    return n + 1;
  }

  private static void swap(int[] A, int x, int y) {
    A[x] = A[x] + A[y];
    A[y] = A[x] - A[y];
    A[x] = A[x] - A[y];
  }

  public static int firstMissingPositiveTried(int[] array) {
    int n = array.length;

    // First, segregate positive and non-positive numbers
    int shift = segregate(array);

    // Work on the subarray containing only positives
    int[] posArray = new int[n - shift];
      System.arraycopy(array, 0 + shift, posArray, 0, posArray.length);

    // Mark elements as negative to indicate presence
    for (int i = 0; i < posArray.length; i++) {
      int absVal = Math.abs(posArray[i]);
      if (absVal - 1 < posArray.length && posArray[absVal - 1] > 0) {
        posArray[absVal - 1] = -posArray[absVal - 1];
      }
    }

    // Find the first positive element's index
    for (int i = 0; i < posArray.length; i++) {
      if (posArray[i] > 0) {
        return i + 1;
      }
    }

    return posArray.length + 1;
  }

  private static int segregate(int[] array) {
    int j = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] <= 0) {
        swap(array, i, j);
        j++;
      }
    }
    return j;
  }
}
