package main.java.miscellaneous;

import java.util.*;

public class CombinationsSum {
  public static void main(String[] args) {
    CombinationsSum runner = new CombinationsSum();
    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    List<List<Integer>> result = runner.combinationSum2(candidates, target);
    result.forEach(System.out::println);
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> uniqueCombinations = new ArrayList<>();
    Arrays.sort(candidates);
    backtracking(candidates, 0, target, uniqueCombinations, new ArrayList<>());
    return uniqueCombinations;
  }

  private void backtracking(
      int[] candidates, int start, int remaining, List<List<Integer>> result, List<Integer> list) {
    if (remaining == 0) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1]) continue;

      if (candidates[i] > remaining) break;

      list.add(candidates[i]);
      backtracking(candidates, i + 1, remaining - candidates[i], result, list);
//      list.removeLast();
    }
  }
}
