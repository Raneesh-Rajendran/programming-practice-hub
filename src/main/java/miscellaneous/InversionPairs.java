package main.java.miscellaneous;

import java.util.Arrays;

public class InversionPairs {

  static int mod = 1000000007;
  static int count = 0;

  public static void main(String[] args) {
    int[] A = new int[] {3, 4, 1, 2};
    mergeSort(A, 0, A.length - 1);
    System.out.println(Arrays.toString(A));
    System.out.println(count);
  }

  public static void mergeSort(int[] A, int s, int e) {
    if (s >= e) return;
    int m = (s + e) / 2;
    mergeSort(A, s, m);
    mergeSort(A, m + 1, e);
    merge(A, s, m, e);
  }

  public static void merge(int[] A, int s, int m, int e) {
    int[] left = Arrays.copyOfRange(A, s, m + 1);
    int[] right = Arrays.copyOfRange(A, m + 1, e + 1);
    int N = left.length;
    int M = right.length;
    int k = s, i = 0, j = 0;
    while (i < N && j < M) {
      if (left[i] <= right[j]) A[k++] = left[i++];
      else {
        A[k++] = right[j++];
        count = (count + (N - i)) % mod;
      }
    }

    while (i < N) A[k++] = left[i++];

    while (j < M) A[k++] = right[j++];
  }
}
