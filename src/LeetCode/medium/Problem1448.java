package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">1448. Count Good Nodes in Binary Tree</a>
 */
public class Problem1448 {

  public static void main(String[] args) {
    assertEquals(4, goodNodes(TreeNode.buildTree(new Integer[] {3,1,4,3,null,1,5})));
    assertEquals(3, goodNodes(TreeNode.buildTree(new Integer[] {3,3,null,4,2})));
    assertEquals(1, goodNodes(TreeNode.buildTree(new Integer[] {1})));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int goodNodes(TreeNode root) {
    return goodNodesRecursive(root, Integer.MIN_VALUE);
  }

  private static int goodNodesRecursive(TreeNode node, int maxSoFar) {
    if (node == null) {
      return 0;
    }
    int numGoodNodes = 0;
    if (node.val >= maxSoFar) {
      maxSoFar = node.val;
      numGoodNodes++;
    }
    numGoodNodes += goodNodesRecursive(node.left, maxSoFar);
    numGoodNodes += goodNodesRecursive(node.right, maxSoFar);
    return numGoodNodes;
  }

//  /**
//   * Approach: Pre-order DFS (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int goodNodes(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//    int numGoodNodes = 0;
//    Deque<Pair> stack = new ArrayDeque<>();
//    stack.push(new Pair(root, Integer.MIN_VALUE));
//    while (!stack.isEmpty()) {
//      Pair pair = stack.pop();
//      TreeNode node = pair.node;
//      int maxSoFar = pair.maxSoFar;
//      if (node.val >= maxSoFar) {
//        maxSoFar = node.val;
//        numGoodNodes++;
//      }
//      if (node.left != null) {
//        stack.push(new Pair(node.left, maxSoFar));
//      }
//      if (node.right != null) {
//        stack.push(new Pair(node.right, maxSoFar));
//      }
//    }
//    return numGoodNodes;
//  }
//
//  static class Pair {
//    TreeNode node;
//    int maxSoFar;
//    Pair(TreeNode node, int maxSoFar) {
//      this.node = node;
//      this.maxSoFar = maxSoFar;
//    }
//  }
}
