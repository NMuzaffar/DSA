package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

import Structy.common.ListNode;

/**
 * <a href="https://structy.net/problems/linked-list-find">Linked List Find</a>
 */
public class LinkedListFind {

  public static void main(String[] args) {
    assertEquals(true, linkedListFind(ListNode.fromArray(new String[] {"a", "b", "c", "d"}), "c"));
    assertEquals(true, linkedListFind(ListNode.fromArray(new String[] {"a", "b", "c", "d"}), "d"));
    assertEquals(false, linkedListFind(ListNode.fromArray(new String[] {"a", "b", "c", "d"}), "q"));
    assertEquals(true, linkedListFind(ListNode.fromArray(new String[] {"jason", "leneli"}), "jason"));
    assertEquals(true, linkedListFind(ListNode.fromArray(new Integer[] {42}), 42));
    assertEquals(false, linkedListFind(ListNode.fromArray(new Integer[] {42}), 100));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static <T> boolean linkedListFind(ListNode<T> head, T target) {
    if (head == null) {
      return false;
    }
    if (head.val == target) {
      return true;
    }
    return linkedListFind(head.next, target);
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> boolean linkedListFind(ListNode<T> head, T target) {
//    ListNode<T> curr = head;
//    while (curr != null) {
//      if (curr.val == target) {
//        return true;
//      }
//      curr = curr.next;
//    }
//    return false;
//  }
}
