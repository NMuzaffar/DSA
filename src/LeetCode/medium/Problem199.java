package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">199. Binary Tree Right Side View</a>
 */
public class Problem199 {

  public static void main(String[] args) {
    assertEquals(new ArrayList<>(List.of(1,3,4)), rightSideView(TreeNode.buildTree(new Integer[] {1,2,3,null,5,null,4})));
    assertEquals(new ArrayList<>(List.of(1,3,4,5)), rightSideView(TreeNode.buildTree(new Integer[] {1,2,3,4,null,null,null,5})));
    assertEquals(new ArrayList<>(List.of(1,3)), rightSideView(TreeNode.buildTree(new Integer[] {1,null,3})));
    assertEquals(new ArrayList<>(List.of()), rightSideView(TreeNode.buildTree(new Integer[] {})));
  }

  /**
   * Approach: Reverse Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightSide = new ArrayList<>();
    preorder(root, 0, rightSide);
    return rightSide;
  }

  private static void preorder(TreeNode node, int level, List<Integer> rightSide) {
    if (node == null) {
      return;
    }
    if (level == rightSide.size()) {
      rightSide.add(node.val);
    }
    preorder(node.right, level + 1, rightSide);
    preorder(node.left, level + 1, rightSide);
  }

//  /**
//   * Approach: BFS <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<Integer> rightSideView(TreeNode root) {
//    if (root == null) {
//      return Collections.emptyList();
//    }
//    List<Integer> answer = new ArrayList<>();
//    Queue<TreeNode> queue = new ArrayDeque<>();
//    queue.add(root);
//    while (!queue.isEmpty()) {
//      int levelLength = queue.size();
//      for (int i = 0; i < levelLength; i++) {
//        TreeNode node = queue.remove();
//        if (i == levelLength - 1) {
//          answer.add(node.val);
//        }
//        if (node.left != null) {
//          queue.add(node.left);
//        }
//        if (node.right != null) {
//          queue.add(node.right);
//        }
//      }
//    }
//    return answer;
//  }
}
