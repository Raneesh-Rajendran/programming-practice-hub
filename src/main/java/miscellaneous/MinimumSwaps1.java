package main.java.miscellaneous;

public class MinimumSwaps1 {

  public static void main(String[] args) {
    int[] A = {1, 14, 10, 13, 3, 10, 5, 5};
    int B = 8;

    System.out.println(MinimumSwaps1.solve(A, B));
  }

  public static int solve(int[] A, int B) {
    int lessCount = 0, bigCount = 0;
    int ans = 0;

    for (int element : A) if (element <= B) lessCount++;

    for (int i = 0; i < lessCount; i++) if (A[i] > B) bigCount++;

    ans = bigCount;

    for (int i = 0, j = lessCount; j < A.length; i++, j++) {
      if (A[i] > B) bigCount--;
      if (A[j] > B) bigCount++;

      ans = Math.min(ans, bigCount);
    }

    return ans;
  }
}
