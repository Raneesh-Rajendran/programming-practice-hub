package main.java.miscellaneous;

/*
arr = {0, -1, 2, -3, 1}
arr = {-3, -2, -1, 0, 1, 2}
ans = {{0,-1,1}, {2,-3,1}}
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripletZeroSum {

  public static void main(String[] args) {
    List<Integer> array = new ArrayList<>(List.of(0, -1, 2, -3, 1));
    List<int[]> result = new ArrayList<>();
    Collections.sort(array);
    for (int i = 0; i < array.size() - 1; i++) {
      int start = i + 1, end = array.size() - 1;
      while (start < end) {
        int sum = array.get(i) + array.get(start) + array.get(end);
        if (sum == 0) {
          result.add(new int[] {array.get(i), array.get(start), array.get(end)});
          start++;
          end--;
        } else if (sum < 0) {
          start++;
        } else {
          end--;
        }
      }
    }

    result.forEach(e -> System.out.println(e[0] + "," + e[1] + "," + e[2]));
  }
}
