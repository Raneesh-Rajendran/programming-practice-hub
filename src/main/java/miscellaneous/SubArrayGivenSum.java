package main.java.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayGivenSum {

  public static void main(String[] args) {
    int[] A = {1, 2, 3};
    int B = 3;
    System.out.println(Arrays.toString(solve(A, B)));
    A = new int[] {1, 2, 3};
    System.out.println(subArraySumPos(A, B));
    A = new int[] {-1, -1, 1};
    B = 0;
    System.out.println(subArraySum(A, B));
  }

  public static int subArraySumPos(int[] A, int B) {
    int ans = 0;
    int n = A.length;
    if (n == 0) return ans;

    if (n == 1) {
      if (A[0] == B) return 1;
      else return ans;
    }

    if (n == 2) {
      if (A[0] + A[1] == B) return 1;
      else return ans;
    }

    int s = 0, e = 1;
    int sum = A[s] + A[e];

    while (s < n && e < n) {
      if (sum == B) {
        ans++;
      }

      if (sum < B) {
        e++;
        if (e < n) {
          sum += A[e];
        }
      } else {
        sum -= A[s];
        s++;
        if (s < e) {
          e = s;
          sum = A[s];
        }
      }
    }

    return ans;
  }

  public static int subArraySum(int[] A, int B) {
    int count = 0;
    int sum = 0;
    Map<Integer, Integer> sumOccurrences = new HashMap<>();

    // Initialize with the sum 0 occurring once
    sumOccurrences.put(0, 1);

    for (int a : A) {
      sum += a;

      // Check if there is a subarray (ending at the current index) which sums to B
      if (sumOccurrences.containsKey(sum - B)) {
        count += sumOccurrences.get(sum - B);
      }

      // Add the current sum into the map or update its occurrence
      sumOccurrences.put(sum, sumOccurrences.getOrDefault(sum, 0) + 1);
    }

    return count;
  }

  public static int[] solve(int[] A, int B) {
    int[] ans = {-1};
    int n = A.length;
    if (n == 0) return ans;

    if (n == 1 && A[0] == B) return new int[] {0, 0};
    else if (n == 2 && A[0] + A[1] == B) return new int[] {0, 1};

    int s = 0, e = 1;
    int sum = A[s] + A[e];

    while (s < n && e < n) {
      if (sum == B) {
        int[] result = new int[(e + 1) - s];
          if (e + 1 - s >= 0) System.arraycopy(A, s, result, s - s, e + 1 - s);
        return result;
      }

      if (sum < B) {
        e++;
        if (e < n) {
          sum += A[e];
        }
      } else {
        sum -= A[s];
        s++;
        if (s > e && s < n) {
          e = s;
          sum = A[s];
        }
      }
    }

    return ans;
  }
}
