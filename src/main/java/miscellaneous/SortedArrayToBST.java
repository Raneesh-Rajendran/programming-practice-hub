package main.java.miscellaneous;

public class SortedArrayToBST {

  public static void main(String[] args) {
    SortedArrayToBST solution = new SortedArrayToBST();
    solution.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  public TreeNode helper(int[] nums, int low, int high) {
    if (low > high) return null;
    int mid = low + (high - low) / 2;
    TreeNode head = new TreeNode(nums[mid]);
    head.left = helper(nums, low, mid - 1);
    head.right = helper(nums, mid + 1, high);
    return head;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
