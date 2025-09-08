package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/premium/remove-node">Remove Node</a>
 */
public class RemoveNode {

  public static void main(String[] args) {
    assertEquals(null, removeNode(null, "a"));

    assertEquals(
        Node.fromArray(new String[] {"a", "b", "d", "e", "f"}),
        removeNode(Node.fromArray(new String[] {"a", "b", "c", "d", "e", "f"}), "c"));

    assertEquals(
        Node.fromArray(new String[] {"x", "y"}),
        removeNode(Node.fromArray(new String[] {"x", "y", "z"}), "z"));

    assertEquals(
        Node.fromArray(new String[] {"r", "s"}),
        removeNode(Node.fromArray(new String[] {"q", "r", "s"}), "q"));

    assertEquals(
        Node.fromArray(new String[] {"h", "j", "i"}),
        removeNode(Node.fromArray(new String[] {"h", "i", "j", "i"}), "i"));

    assertEquals(
        null,
        removeNode(Node.fromArray(new String[] {"t"}), "t"));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static <T> Node<T> removeNode(Node<T> head, T targetVal) {
    if (head == null) {
      return null;
    }
    if (head.val == targetVal) {
      return head.next;
    }
    head.next = removeNode(head.next, targetVal);
    return head;
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> ListNode<T> removeNode(ListNode<T> head, T targetVal) {
//    ListNode<T> sentinel = new ListNode<>(null);
//    sentinel.next = head;
//    ListNode<T> curr = head;
//    ListNode<T> prev = sentinel;
//    while (curr != null) {
//      if (curr.val == targetVal) {
//        prev.next = curr.next;
//        break;
//      }
//      prev = curr;
//      curr = curr.next;
//    }
//    return sentinel.next;
//  }
}
