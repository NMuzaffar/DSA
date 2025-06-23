package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
 */
public class Problem19 {

  public static void main(String[] args) {
    assertEquals(
        ListNode.fromArray(new int[] {1,2,3,5}),
        removeNthFromEnd(ListNode.fromArray(new int[] {1,2,3,4,5}), 2));

    assertEquals(
        ListNode.fromArray(new int[] {}),
        removeNthFromEnd(ListNode.fromArray(new int[] {1}), 1));

    assertEquals(
        ListNode.fromArray(new int[] {1}),
        removeNthFromEnd(ListNode.fromArray(new int[] {1,2}), 1));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode sentinel = new ListNode(-1);
    sentinel.next = head;
    ListNode leader = sentinel;
    ListNode trailer = sentinel;
    for (int i = 0; i < n; i++) {
      leader = leader.next;
      if (leader == null) {
        return head;
      }
    }
    while (leader.next != null) {
      leader = leader.next;
      trailer = trailer.next;
    }
    trailer.next = trailer.next.next;
    return sentinel.next;
  }
}
