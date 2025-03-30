package main.java.miscellaneous;

public class MaxConsecutiveOnes {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0};
    MaxConsecutiveOnes.longestOnes(nums, 2);
    int[] nums1 = {1, 1, 0, 1, 1, 1};
    // MaxConsecutiveOnes.findMaxConsecutiveOnes(nums1);
  }

  public static int longestOnes(int[] nums, int k) {
    int i = 0, j;
    for (j = 0; j < nums.length; ++j) {
      if (nums[j] == 0) k--;
      if (k < 0 && nums[i++] == 0) k++;
    }
    return j - i;
  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    int i = 0, sum = 0, ans = 0;
    while (i < nums.length) {
      sum += nums[i];
      if (nums[i] == 0) {
        ans = Math.max(sum, ans);
        sum = 0;
      }
      i++;
    }
    return ans;
  }

  public int characterReplacement(String s, int k) {
    int[] freq = new int[26];
    int left = 0, max = 0, mostFreq = 0;

    for (int right = 0; right < s.length(); right++) {
      freq[s.charAt(right) - 'A']++;
      mostFreq = Math.max(mostFreq, freq[s.charAt(right) - 'A']);

      int changeLetter = (right - left + 1) - mostFreq;
      if (changeLetter > k) {
        freq[s.charAt(right) - 'A']--;
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
