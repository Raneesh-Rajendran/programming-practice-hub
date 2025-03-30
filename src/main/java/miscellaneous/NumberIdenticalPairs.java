package main.java.miscellaneous;

class Solution {
  public static void main(String[] args) {

    int[] nums = new int[] {1, 2, 3, 1, 1, 3};
    Solution solution = new Solution();
    solution.numIdenticalPairs(nums);
  }

  public int numIdenticalPairs(int[] nums) {
    int sum = 0;
    int[] count = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
      sum = sum + count[nums[i]] - 1;
    }
    return sum;
  }
}
