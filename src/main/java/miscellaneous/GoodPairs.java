package main.java.miscellaneous;

public class GoodPairs {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 1, 1, 3};
    int res = 0;
      int[] count = new int[101];
      for (int a : nums) {
      res += count[a]++;
    }
    System.out.println(res);
  }
}
