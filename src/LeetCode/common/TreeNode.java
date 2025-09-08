package LeetCode.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode buildTree(Integer[] values) {
    if (values == null || values.length == 0 || values[0] == null) return null;

    TreeNode root = new TreeNode(values[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;
    while (i < values.length) {
      TreeNode current = queue.poll();
      if (i < values.length && values[i] != null) {
        current.left = new TreeNode(values[i]);
        queue.offer(current.left);
      }
      i++;
      if (i < values.length && values[i] != null) {
        current.right = new TreeNode(values[i]);
        queue.offer(current.right);
      }
      i++;
    }
    return root;
  }

  public static void printLevelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      System.out.print((node != null ? node.val : "null") + " ");
      if (node != null) {
        q.offer(node.left);
        q.offer(node.right);
      }
    }
  }
}
