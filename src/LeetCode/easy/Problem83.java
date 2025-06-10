package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">83. Remove Duplicates from Sorted List</a>
 */
public class Problem83 {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {1,2}), deleteDuplicates(ListNode.fromArray(new int[] {1,1,2})));
    assertEquals(ListNode.fromArray(new int[] {1,2,3}), deleteDuplicates(ListNode.fromArray(new int[] {1,1,2,3,3})));
    assertEquals(ListNode.fromArray(new int[] {1}), deleteDuplicates(ListNode.fromArray(new int[] {1,1,1})));
  }

  /**
   * Approach: Straight-Forward Approach <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    while (curr != null && curr.next != null) {
      if (curr.next.val == curr.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
    return head;
  }
}
