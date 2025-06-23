package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">2095. Delete the Middle Node of a Linked List</a>
 */
public class Problem2095 {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {1,3,4,1,2,6}), deleteMiddle(ListNode.fromArray(new int[] {1,3,4,7,1,2,6})));
    assertEquals(ListNode.fromArray(new int[] {1,2,4}), deleteMiddle(ListNode.fromArray(new int[] {1,2,3,4})));
    assertEquals(ListNode.fromArray(new int[] {2}), deleteMiddle(ListNode.fromArray(new int[] {2,1})));
    assertEquals(ListNode.fromArray(new int[] {}), deleteMiddle(ListNode.fromArray(new int[] {1})));
  }

  /**
   * Approach: Fast & Slow Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode deleteMiddle(ListNode head) {
    if (head.next == null) {
      return null;
    }
    ListNode sentinel = new ListNode(-1, head);
    ListNode slow = head;
    /*
      We want to delete the middle node instead of finding it.
      Therefore, we are actually looking for the predecessor of the middle node,
      not the middle node itself, or rather,
      this is like moving slow backward one node after the iteration stops.
     */
    ListNode fast = head.next.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    slow.next = slow.next.next;
    return sentinel.next;
  }

//  /**
//   * Approach: Two Passes <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static ListNode deleteMiddle(ListNode head) {
//    if (head.next == null) {
//      return null;
//    }
//    ListNode sentinel = new ListNode(-1, head);
//    int length = 0;
//    ListNode dummy = head;
//    while (dummy != null) {
//      length++;
//      dummy = dummy.next;
//    }
//    ListNode middlePredecessor = head;
//    for (int i = 0; i < (length / 2) - 1; i++) {
//      middlePredecessor = middlePredecessor.next;
//    }
//    middlePredecessor.next = middlePredecessor.next.next;
//    return sentinel.next;
//  }
}
