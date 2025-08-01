package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">530. Minimum Absolute Difference in BST</a>
 */
public class Problem530 {

  public static void main(String[] args) {
    var problem = new Problem530();
    assertEquals(1, problem.getMinimumDifference(TreeNode.buildTree(new Integer[] {4,2,6,1,3})));
    assertEquals(1, problem.getMinimumDifference(TreeNode.buildTree(new Integer[] {1,0,48,null,null,12,49})));
    assertEquals(1, problem.getMinimumDifference(TreeNode.buildTree(new Integer[] {5,4,7})));
  }

  /**
   * Approach: In-order DFS (Recursive), without List <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public int getMinimumDifference(TreeNode root) {
    minDiff = Integer.MAX_VALUE;
    prevNode = null;
    recursiveInorderDfs(root);
    return minDiff;
  }

  private int minDiff = Integer.MAX_VALUE;
  private TreeNode prevNode = null;

  private void recursiveInorderDfs(TreeNode node) {
    if (node == null) {
      return;
    }
    recursiveInorderDfs(node.left);
    if (prevNode != null) {
      minDiff = Math.min(minDiff, node.val - prevNode.val);
    }
    prevNode = node;
    recursiveInorderDfs(node.right);
  }

//  /**
//   * Approach: In-order DFS (Recursive), using List <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int getMinimumDifference(TreeNode root) {
//    List<Integer> nodeValues = new ArrayList<>();
//    recursiveInorderDfs(root, nodeValues);
//    int minDiff = Integer.MAX_VALUE;
//    for (int i = 1; i < nodeValues.size(); i++) {
//      minDiff = Math.min(minDiff, nodeValues.get(i) - nodeValues.get(i - 1));
//    }
//    return minDiff;
//  }
//
//  private static void recursiveInorderDfs(TreeNode node, List<Integer> nodeValues) {
//    if (node == null) {
//      return;
//    }
//    recursiveInorderDfs(node.left, nodeValues);
//    nodeValues.add(node.val);
//    recursiveInorderDfs(node.right, nodeValues);
//  }

//  /**
//   * Approach: In-order DFS (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int getMinimumDifference(TreeNode root) {
//    List<Integer> nodeValues = iterativeInorderDfs(root);
//    int minDiff = Integer.MAX_VALUE;
//    for (int i = 1; i < nodeValues.size(); i++) {
//      minDiff = Math.min(minDiff, nodeValues.get(i) - nodeValues.get(i - 1));
//    }
//    return minDiff;
//  }
//
//  private static List<Integer> iterativeInorderDfs(TreeNode root) {
//    List<Integer> nodeValues = new ArrayList<>();
//    Deque<TreeNode> stack = new ArrayDeque<>();
//    TreeNode curr = root;
//    while (!stack.isEmpty() || curr != null) {
//      if (curr != null) {
//        stack.push(curr);
//        curr = curr.left;
//      } else {
//        curr = stack.pop();
//        nodeValues.add(curr.val);
//        curr = curr.right;
//      }
//    }
//    return nodeValues;
//  }
}
