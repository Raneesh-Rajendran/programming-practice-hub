package main.java.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum {

  public static void main(String[] args) {
    System.out.println("Hello Java");

    int[] array = new int[] {1, 3, 6, 5, 7, 4, 1, 9};
    List<Integer> list = targetSumSolution(array, 9);
    System.out.println("[" + list.get(0) + "," + list.get(1) + "]");
  }

  public static List<Integer> targetSumSolution(int[] array, int targetSum) {
    List<Integer> list = new ArrayList<>();
    int x = -1, y = -1, xIdx = 0, yIdx = 0;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(targetSum - array[i])) {
        xIdx = map.get(targetSum - array[i]);
        yIdx = i;
        if (array[i] > array[xIdx] || array[i] > array[yIdx]) {
          x = map.get(targetSum - array[i]);
          y = i;
        } else {
          x = xIdx;
          y = yIdx;
        }

      } else {
        map.put(array[i], i);
      }
    }
    list.add(x);
    list.add(y);
    return list;
  }
}
