package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import LeetCode.common.TreeNode;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/deepest-leaves-sum/">1302. Deepest Leaves Sum</a>
 */
public class Problem1302 {

  public static void main(String[] args) {
    assertEquals(15, deepestLeavesSum(TreeNode.buildTree(new Integer[] {1,2,3,4,5,null,6,7,null,null,null,null,8})));
    assertEquals(19, deepestLeavesSum(TreeNode.buildTree(new Integer[] {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5})));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int deepestLeavesSum(TreeNode root) {
    int maxDepth = getMaxDepth(root);
    return dfs(root, 1, maxDepth);
  }

  private static int dfs(TreeNode node, int currDepth, int maxDepth) {
    if (node == null) {
      return 0;
    }
    if (currDepth == maxDepth) {
      return node.val;
    }
    int left = dfs(node.left, currDepth + 1, maxDepth);
    int right = dfs(node.right, currDepth + 1, maxDepth);
    return left + right;
  }

  private static int getMaxDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = getMaxDepth(node.left);
    int right = getMaxDepth(node.right);
    return Math.max(left, right) + 1;
  }

//  /**
//   * Approach: BFS <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int deepestLeavesSum(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//    int sum = 0;
//    Queue<TreeNode> queue = new ArrayDeque<>();
//    queue.add(root);
//    while (!queue.isEmpty()) {
//      int currLength = queue.size();
//      sum = 0;
//      for (int i = 0; i < currLength; i++) {
//        TreeNode node = queue.remove();
//        sum += node.val;
//        if (node.left != null) {
//          queue.add(node.left);
//        }
//        if (node.right != null) {
//          queue.add(node.right);
//        }
//      }
//    }
//    return sum;
//  }
}
