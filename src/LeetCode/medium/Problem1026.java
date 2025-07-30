package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">1026. Maximum Difference Between Node and Ancestor</a>
 */
public class Problem1026 {

  public static void main(String[] args) {
    assertEquals(7, maxAncestorDiff(TreeNode.buildTree(new Integer[] {8,3,10,1,6,null,14,null,null,4,7,13})));
    assertEquals(3, maxAncestorDiff(TreeNode.buildTree(new Integer[] {1,null,2,null,0,3})));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return maxAncestorDiffRecursive(root, root.val, root.val);
  }

  private static int maxAncestorDiffRecursive(TreeNode node, int currMax, int currMin) {
    if (node == null) {
      return currMax - currMin;
    }
    currMax = Math.max(currMax, node.val);
    currMin = Math.min(currMin, node.val);
    int left = maxAncestorDiffRecursive(node.left, currMax, currMin);
    int right = maxAncestorDiffRecursive(node.right, currMax, currMin);
    return Math.max(left, right);
  }
}
