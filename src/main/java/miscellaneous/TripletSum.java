package main.java.miscellaneous;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array and a value, find if there is a triplet in that array whose sum is equal to the
 * given value. If there is such a triplet present in array, return true.
 *
 * <p>Else, return false.
 *
 * <p>For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a
 * triplet (12, 3 and 9) present in array whose sum is 24, return true.
 */
public class TripletSum {

  public static boolean findTriplet(int[] nums, int sum) {
    // Your code here
    Set<Integer> set = new HashSet<>();

      for (int num : nums) {
          set.add(num);
      }

    int i = 0, j = nums.length - 1;

    while (i < j) {
      int twoSum = nums[i] + nums[j];
      if (set.contains(sum - twoSum)) {
        return true;
      }
      i++;
      j--;
    }

    return false;
  }

  public static void main(String[] args) {
    TripletSum instance = new TripletSum();
    instance.test1();
    instance.test2();
    instance.test3();
    instance.test4();
  }

  public void test1() {
    int[] input = new int[] {1, 4, 45, 6, 10, 8};
    int sum = 22;
    System.out.println(findTriplet(input, sum));
  }

  public void test2() {
    int[] input = new int[] {1, 4, 4, 6, 6, 8};
    int sum = 16;
    System.out.println(findTriplet(input, sum));
  }

  public void test3() {
    int[] input = new int[] {1, -4, 45, -6, 10, 8};
    int sum = 49;
    System.out.println(findTriplet(input, sum));
  }

  public void test4() {
    int[] input = new int[] {1, 4, 4, 6, 6, 6, 8};
    int sum = 24;
    System.out.println(findTriplet(input, sum));
  }
}
