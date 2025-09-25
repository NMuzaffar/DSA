package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://structy.net/problems/premium/insert-node">Insert Node</a>
 */
public class InsertNode {

  public static void main(String[] args) {
    assertEquals(
        Node.fromArray(new String[] {"a", "b", "x", "c", "d"}),
        insertNode(Node.fromArray(new String[] {"a", "b", "c", "d"}), "x", 2));

    assertEquals(
        Node.fromArray(new String[] {"a", "b", "c", "v", "d"}),
        insertNode(Node.fromArray(new String[] {"a", "b", "c", "d"}), "v", 3));

    assertEquals(
        Node.fromArray(new String[] {"a", "b", "c", "d", "m"}),
        insertNode(Node.fromArray(new String[] {"a", "b", "c", "d"}), "m", 4));

    assertEquals(
        Node.fromArray(new String[] {"z", "a", "b"}),
        insertNode(Node.fromArray(new String[] {"a", "b"}), "z", 0));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static <T> Node<T> insertNode(Node<T> head, T value, int index) {
    if (index == 0) {
      Node<T> newNode = new Node<>(value);
      newNode.next = head;
      return newNode;
    }
    if (head == null) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    head.next = insertNode(head.next, value, index - 1);
    return head;
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> ListNode<T> insertNode(ListNode<T> head, T value, int index) {
//    ListNode<T> sentinel = new ListNode<>(null);
//    sentinel.next = head;
//    ListNode<T> curr = head;
//    ListNode<T> prev = sentinel;
//    for (; curr != null && index > 0; index--) {
//      prev = curr;
//      curr = curr.next;
//    }
//    if (index == 0) {
//      ListNode<T> newNode = new ListNode<>(value);
//      newNode.next = curr;
//      prev.next = newNode;
//      return sentinel.next;
//    } else {
//      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
//    }
//  }
}
