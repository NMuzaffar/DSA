package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

import Structy.common.ListNode;

/**
 * <a href="https://structy.net/problems/premium/is-univalue-list">Is Univalue List</a>
 */
public class IsUnivalueList {

  public static void main(String[] args) {
    assertTrue(isUnivalueList(ListNode.fromArray(new Integer[] {7, 7, 7})));
    assertFalse(isUnivalueList(ListNode.fromArray(new Integer[] {7, 7, 4})));
    assertTrue(isUnivalueList(ListNode.fromArray(new Integer[] {2, 2, 2, 2, 2})));
    assertFalse(isUnivalueList(ListNode.fromArray(new Integer[] {2, 2, 3, 3, 2})));
    assertTrue(isUnivalueList(ListNode.fromArray(new String[] {"z"})));
    assertFalse(isUnivalueList(ListNode.fromArray(new Integer[] {2, 1, 2, 2, 2})));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static <T> boolean isUnivalueList(ListNode<T> head) {
    if (head == null || head.next == null) {
      return true;
    }
    if (head.val != head.next.val) {
      return false;
    }
    return isUnivalueList(head.next);
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> boolean isUnivalueList(ListNode<T> head) {
//    ListNode<T> curr = head;
//    while (curr != null && curr.next != null) {
//      if (curr.val != curr.next.val) {
//        return false;
//      }
//      curr = curr.next;
//    }
//    return true;
//  }
}
