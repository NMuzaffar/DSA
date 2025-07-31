package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import LeetCode.common.TreeNode;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">515. Find Largest Value in Each Tree Row</a>
 */
public class Problem515 {

  public static void main(String[] args) {
    assertEquals(new ArrayList<>(List.of(1,3,9)), largestValues(TreeNode.buildTree(new Integer[] {1,3,2,5,3,null,9})));
    assertEquals(new ArrayList<>(List.of(1,3)), largestValues(TreeNode.buildTree(new Integer[] {1,2,3})));
    assertEquals(new ArrayList<>(List.of(3,5,6)), largestValues(TreeNode.buildTree(new Integer[] {3,1,5,0,2,4,6})));
  }

  /**
   * Approach: Pre-order DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> largestValues(TreeNode root) {
    List<Integer> largest = new ArrayList<>();
    preorder(root, 0, largest);
    return largest;
  }

  private static void preorder(TreeNode node, int depth, List<Integer> largest) {
    if (node == null) {
      return;
    }
    if (depth == largest.size()) {
      largest.add(node.val);
    } else {
      largest.set(depth, Math.max(largest.get(depth), node.val));
    }
    preorder(node.left, depth + 1, largest);
    preorder(node.right, depth + 1, largest);
  }

//  /**
//   * Approach: BFS <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<Integer> largestValues(TreeNode root) {
//    if (root == null) {
//      return Collections.emptyList();
//    }
//    List<Integer> answer = new ArrayList<>();
//    Queue<TreeNode> queue = new ArrayDeque<>();
//    queue.add(root);
//    while (!queue.isEmpty()) {
//      int currLength = queue.size();
//      int currMax = Integer.MIN_VALUE;
//      for (int i = 0; i < currLength; i++) {
//        TreeNode node = queue.remove();
//        currMax = Math.max(currMax, node.val);
//        if (node.left != null) {
//          queue.add(node.left);
//        }
//        if (node.right != null) {
//          queue.add(node.right);
//        }
//      }
//      answer.add(currMax);
//    }
//    return answer;
//  }
}
