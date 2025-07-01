package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a>
 */
public class Problem104 {

  public static void main(String[] args) {
    assertEquals(3, maxDepth(TreeNode.buildTree(new Integer[] {3,9,20,null,null,15,7})));
    assertEquals(2, maxDepth(TreeNode.buildTree(new Integer[] {1,null,2})));
  }

  /**
   * Approach: Post-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }

//  /**
//   * Approach: Pre-order DFS (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int maxDepth(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//    Deque<Pair> stack = new ArrayDeque<>();
//    stack.push(new Pair(root, 1));
//    int answer = 0;
//    while (!stack.isEmpty()) {
//      Pair pair = stack.poll();
//      TreeNode node = pair.node;
//      int depth = pair.depth;
//      answer = Math.max(answer, depth);
//      if (node.left != null) {
//        stack.push(new Pair(node.left, depth + 1));
//      }
//      if (node.right != null) {
//        stack.push(new Pair(node.right, depth + 1));
//      }
//    }
//    return answer;
//  }
//
//  static class Pair {
//    TreeNode node;
//    int depth;
//    Pair(TreeNode node, int depth) {
//      this.node = node;
//      this.depth = depth;
//    }
//  }
}
