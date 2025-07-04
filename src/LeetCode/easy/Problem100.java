package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/same-tree/">100. Same Tree</a>
 */
public class Problem100 {

  public static void main(String[] args) {
    assertTrue(isSameTree(TreeNode.buildTree(new Integer[] {1,2,3}), TreeNode.buildTree(new Integer[] {1,2,3})));
    assertFalse(isSameTree(TreeNode.buildTree(new Integer[] {1,2}), TreeNode.buildTree(new Integer[] {1,null,2})));
    assertFalse(isSameTree(TreeNode.buildTree(new Integer[] {1,2,1}), TreeNode.buildTree(new Integer[] {1,1,2})));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    boolean left = isSameTree(p.left, q.left);
    boolean right = isSameTree(p.right, q.right);
    return left && right;
  }

//  /**
//   * Approach: Pre-order DFS (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean isSameTree(TreeNode p, TreeNode q) {
//    Deque<Pair> stack = new ArrayDeque<>();
//    stack.push(new Pair(p, q));
//    while (!stack.isEmpty()) {
//      Pair pair = stack.pop();
//      TreeNode node1 = pair.node1;
//      TreeNode node2 = pair.node2;
//      if (node1 == null && node2 == null) {
//        continue;
//      }
//      if (node1 == null || node2 == null) {
//        return false;
//      }
//      if (node1.val != node2.val) {
//        return false;
//      }
//      stack.push(new Pair(node1.left, node2.left));
//      stack.push(new Pair(node1.right, node2.right));
//    }
//    return true;
//  }
//
//  static class Pair {
//    TreeNode node1;
//    TreeNode node2;
//    Pair(TreeNode node1, TreeNode node2) {
//      this.node1 = node1;
//      this.node2 = node2;
//    }
//  }
}
