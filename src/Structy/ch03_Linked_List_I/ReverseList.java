package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://structy.net/problems/reverse-list">Reverse List</a>
 */
public class ReverseList {

  public static void main(String[] args) {
    assertEquals(Node.fromArray(new String[] {"f", "e", "d", "c", "b", "a"}), reverseList(
        Node.fromArray(new String[] {"a", "b", "c", "d", "e", "f"})));
    assertEquals(
        Node.fromArray(new String[] {"y", "x"}), reverseList(Node.fromArray(new String[] {"x", "y"})));
    assertEquals(Node.fromArray(new String[] {"p"}), reverseList(Node.fromArray(new String[] {"p"})));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static <T> Node<T> reverseList(Node<T> head) {
    return reverseListHelper(head, null);
  }

  private static <T> Node<T> reverseListHelper(Node<T> head, Node<T> prev) {
    if (head == null) {
      return prev;
    }
    Node<T> nextNode = head.next;
    head.next = prev;
    return reverseListHelper(nextNode, head);
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> ListNode<T> reverseList(ListNode<T> head) {
//    ListNode<T> curr = head;
//    ListNode<T> prev = null;
//    while (curr != null) {
//      ListNode<T> nextNode = curr.next;
//      curr.next = prev;
//      prev = curr;
//      curr = nextNode;
//    }
//    return prev;
//  }
}
