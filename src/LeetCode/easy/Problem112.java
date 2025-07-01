package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/path-sum/">112. Path Sum</a>
 */
public class Problem112 {

  public static void main(String[] args) {
    assertTrue(hasPathSum(TreeNode.buildTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1}), 22));
    assertFalse(hasPathSum(TreeNode.buildTree(new Integer[] {1,null,2}), 5));
    assertFalse(hasPathSum(TreeNode.buildTree(new Integer[] {}), 0));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    targetSum -= root.val;
    if (root.left == null && root.right == null) {
      return targetSum == 0;
    }
    boolean left = hasPathSum(root.left, targetSum);
    boolean right = hasPathSum(root.right, targetSum);
    return  left || right;
  }

//  /**
//   * Approach: Pre-order DFS (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean hasPathSum(TreeNode root, int targetSum) {
//    if (root == null) {
//      return false;
//    }
//    Deque<Pair> stack = new ArrayDeque<>();
//    stack.push(new Pair(root, targetSum));
//    while (!stack.isEmpty()) {
//      Pair pair = stack.pop();
//      TreeNode node = pair.node;
//      int currSum = pair.currSum - node.val;
//      if ((node.left == null) && (node.right == null) && (currSum == 0)) {
//        return true;
//      }
//      if (node.left != null) {
//        stack.push(new Pair(node.left, currSum));
//      }
//      if (node.right != null) {
//        stack.push(new Pair(node.right, currSum));
//      }
//    }
//    return false;
//  }
//
//  static class Pair {
//    TreeNode node;
//    int currSum;
//    Pair(TreeNode node, int currSum) {
//      this.node = node;
//      this.currSum = currSum;
//    }
//  }
}
