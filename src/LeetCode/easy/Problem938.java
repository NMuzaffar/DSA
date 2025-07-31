package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 */
public class Problem938 {

  public static void main(String[] args) {
    assertEquals(32, rangeSumBST(TreeNode.buildTree(new Integer[] {10,5,15,3,7,null,18}), 7 ,15));
    assertEquals(23, rangeSumBST(TreeNode.buildTree(new Integer[] {10,5,15,3,7,13,18,1,null,6}), 6 ,10));
  }

  /**
   * Approach: In-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (low < root.val) {
      sum += rangeSumBST(root.left, low, high);
    }
    if (low <= root.val && root.val <= high) {
      sum += root.val;
    }
    if (root.val < high) {
      sum += rangeSumBST(root.right, low, high);
    }
    return sum;
  }

//  /**
//   * Approach: Pre-order DFS (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int rangeSumBST(TreeNode root, int low, int high) {
//    int sum = 0;
//    Deque<TreeNode> stack = new ArrayDeque<>();
//    stack.push(root);
//    while (!stack.isEmpty()) {
//      TreeNode node = stack.pop();
//      if (low <= node.val && node.val <= high) {
//        sum += node.val;
//      }
//      if (node.left != null && low < node.val) {
//        stack.push(node.left);
//      }
//      if (node.right != null && node.val < high) {
//        stack.push(node.right);
//      }
//    }
//    return sum;
//  }
}
