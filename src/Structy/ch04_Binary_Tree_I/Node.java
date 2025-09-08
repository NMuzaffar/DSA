package Structy.ch04_Binary_Tree_I;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
public class Node<T> {

  public T val;
  public Node<T> left;
  public Node<T> right;

  public Node() {}

  public Node(T val) {
    this.val = val;
  }

  public Node(T val, Node<T> left, Node<T> right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static <T> Node<T> buildTree(T[] values) {
    if (values == null || values.length == 0 || values[0] == null) return null;

    Node<T> root = new Node<>(values[0]);
    Queue<Node<T>> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;
    while (i < values.length) {
      Node<T> current = queue.poll();
      if (i < values.length && values[i] != null) {
        current.left = new Node<>(values[i]);
        queue.offer(current.left);
      }
      i++;
      if (i < values.length && values[i] != null) {
        current.right = new Node<>(values[i]);
        queue.offer(current.right);
      }
      i++;
    }
    return root;
  }

  public static <T> void printLevelOrder(Node<T> root) {
    if (root == null) return;
    Queue<Node<T>> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      Node<T> node = q.poll();
      System.out.print((node != null ? node.val : "null") + " ");
      if (node != null) {
        q.offer(node.left);
        q.offer(node.right);
      }
    }
  }
}
