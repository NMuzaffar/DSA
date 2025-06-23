package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-linked-list-elements/">203. Remove Linked List Elements</a>
 */
public class Problem203 {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {1,2,3,4,5}), removeElements(ListNode.fromArray(new int[] {1,2,6,3,4,5,6}), 6));
    assertEquals(ListNode.fromArray(new int[] {}), removeElements(ListNode.fromArray(new int[] {}), 1));
    assertEquals(ListNode.fromArray(new int[] {}), removeElements(ListNode.fromArray(new int[] {7,7,7,7}), 7));
  }

  /**
   * Approach: Sentinel Node <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode removeElements(ListNode head, int val) {
    ListNode sentinel = new ListNode(-1);
    sentinel.next = head;
    ListNode prev = sentinel;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return sentinel.next;
  }
}
