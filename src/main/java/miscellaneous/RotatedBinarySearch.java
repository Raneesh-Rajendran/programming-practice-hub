package main.java.miscellaneous;

public class RotatedBinarySearch {

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int[] nums1 = {2, 4, 5, 6, 7, 0, 1};
    int[] nums2 = {6, 7, 0, 1, 2, 4, 5};
    System.out.println(RotatedBinarySearch.rotatedBinarySearch(nums, 0, nums.length - 1, 0));
  }

  public static int rotatedBinarySearch(int[] arr, int startIdx, int endIdx, int target) {
    int mid = (startIdx + endIdx) / 2;
    if (arr[mid] == target) return mid;
    if (arr[startIdx] <= arr[mid]) {
      if (target >= arr[startIdx] && target <= arr[mid])
        return rotatedBinarySearch(arr, startIdx, mid - 1, target);
      return rotatedBinarySearch(arr, mid + 1, endIdx, target);
    }
    if (target >= arr[mid] && target <= arr[endIdx])
      return rotatedBinarySearch(arr, mid + 1, endIdx, target);
    return rotatedBinarySearch(arr, startIdx, mid - 1, target);
  }
}
