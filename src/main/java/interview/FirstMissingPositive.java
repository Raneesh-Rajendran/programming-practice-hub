package main.java.interview;

public class FirstMissingPositive {

  public static void main(String[] args) {
    int[] nums = {2, 3, 5, 6};
    int[] nums1 = {-1, -5, -5, 6};
    int[] nums2 = {1, 5, 6, -3};
    int[] nums3 = {1, 2, 3, 4};
    System.out.println(firstMissingPositive(nums));
    System.out.println(firstMissingPositive(nums1));
    System.out.println(firstMissingPositive(nums2));
    System.out.println(firstMissingPositive(nums3));
  }

  public static int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
