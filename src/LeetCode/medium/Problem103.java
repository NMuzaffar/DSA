package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import LeetCode.common.TreeNode;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">103. Binary Tree Zigzag Level Order Traversal</a>
 */
public class Problem103 {

  public static void main(String[] args) {
    assertEquals(
        List.of(new ArrayList<>(List.of(3)), new ArrayList<>(List.of(20,9)), new ArrayList<>(List.of(15,7))),
        zigzagLevelOrder(TreeNode.buildTree(new Integer[] {3,9,20,null,null,15,7})));

    assertEquals(
        List.of(new ArrayList<>(List.of(1))),
        zigzagLevelOrder(TreeNode.buildTree(new Integer[] {1})));

    assertEquals(
        Collections.emptyList(),
        zigzagLevelOrder(TreeNode.buildTree(new Integer[] {})));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> answer = new ArrayList<>();
    preorderDfs(root, 0, answer);
    return answer;
  }

  private static void preorderDfs(TreeNode node, int level, List<List<Integer>> result) {
    if (level >= result.size()) {
     LinkedList<Integer> newLevel = new LinkedList<>();
     newLevel.add(node.val);
     result.add(newLevel);
    } else {
      if (level % 2 == 0) {
        result.get(level).add(node.val);
      } else {
        result.get(level).add(0, node.val);
      }
    }
    if (node.left != null) {
      preorderDfs(node.left, level + 1, result);
    }
    if (node.right != null) {
      preorderDfs(node.right, level + 1, result);
    }
  }

//  /**
//   * Approach: BFS <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//    if (root == null) {
//      return Collections.emptyList();
//    }
//    List<List<Integer>> answer = new ArrayList<>();
//    Deque<TreeNode> deque = new ArrayDeque<>();
//    deque.addLast(root);
//    boolean leftToRight = true;
//    while (!deque.isEmpty()) {
//      int currLength = deque.size();
//      List<Integer> levelVals = new ArrayList<>();
//      for (int i = 0; i < currLength; i++) {
//        if (leftToRight) {
//          TreeNode node = deque.removeFirst();
//          levelVals.add(node.val);
//          if (node.left != null) {
//            deque.addLast(node.left);
//          }
//          if (node.right != null) {
//            deque.addLast(node.right);
//          }
//        } else {
//          TreeNode node = deque.removeLast();
//          levelVals.add(node.val);
//          if (node.right != null) {
//            deque.addFirst(node.right);
//          }
//          if (node.left != null) {
//            deque.addFirst(node.left);
//          }
//        }
//      }
//      answer.add(levelVals);
//      leftToRight = !leftToRight;
//    }
//    return answer;
//  }
}
