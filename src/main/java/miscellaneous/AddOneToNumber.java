package main.java.miscellaneous;

import java.util.Arrays;

public class AddOneToNumber {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(AddOneToNumber.plusOne(new int[] {0, 0, 1, 2, 4})));
  }

  public static int[] plusOne(int[] A) {
    int n = A.length;
    int[] B;
    int count = 0;
    if (n == 1 && A[0] == 0) {
      A[0]++;
      return A;
    }
    for (int k : A) {
      if (k != 0) {
        break;
      } else {
        count++;
      }
    }
    if (count > 0) {
      B = new int[A.length - count];
      int j = 0;
      while (count < A.length) {
        B[j++] = A[count];
        count++;
      }
    } else {
      B = A;
    }

    for (int i = B.length - 1; i >= 0; i--) {
      if (B[i] != 9) {
        B[i]++;
        break;
      } else {
        B[i] = 0;
      }
    }
    if (B[0] == 0) {
      int[] newArr = new int[B.length + 1];
      newArr[0] = 1;
      return newArr;
    }
    return B;
  }
}
