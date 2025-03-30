package main.java.miscellaneous;

import java.util.*;

public class GroupPairs {

  // CODE EXAMPLE VALID FOR COMPILING
  public static void main(String[] args) {
    // Input: [[6,10],[15,18],[1,3],[2,6]]
    int[][] pairs = new int[4][2];
    pairs[0][0] = 6;
    pairs[0][1] = 10;
    pairs[1][0] = 15;
    pairs[1][1] = 18;
    pairs[2][0] = 1;
    pairs[2][1] = 3;
    pairs[3][0] = 2;
    pairs[3][1] = 6;

    System.out.println(Arrays.deepToString(group(pairs)));

    // Output: [[1,10],[15,18]]
  }

  private static int[][] group(int[][] pairs) {
    LinkedList<int[]> result = new LinkedList<>();
    Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
    // Input: [[1,3],[2,6],[6,10],[15,18]]
    for (int[] element : pairs) {
      if (result.isEmpty() || result.getLast()[1] < element[0]) {
        result.add(element);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], element[1]);
      }
    }
    int[][] resultArray = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      resultArray[i] = result.get(i);
      resultArray[i] = result.get(i);
    }
    return resultArray;
  }
}
