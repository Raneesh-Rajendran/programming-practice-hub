package main.java.miscellaneous;

import java.util.Arrays;

public class TrappingRainWater {

  public static int prefixSum(int[] height) {
    int[] leftMaxArr = new int[height.length];

    for (int i = 1; i < height.length; i++) {
      leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
    }

    System.out.println(Arrays.toString(leftMaxArr));

    return 0;
  }

  public static int trap(int[] height) {
    int result = 0;
    int leftMax = 0, rightMax = 0;
    int left = 0, right = height.length - 1;

    while (left <= right) {
      if (height[left] <= height[right]) {

        if (height[left] >= leftMax) leftMax = height[left];
        else result += leftMax - height[left];
        left++;
      } else {
        if (height[right] >= rightMax) rightMax = height[right];
        else result += rightMax - height[right];
        right--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(TrappingRainWater.trap(array));
  }
}
