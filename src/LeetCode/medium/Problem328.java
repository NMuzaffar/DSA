package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/odd-even-linked-list/">328. Odd Even Linked List</a>
 */
public class Problem328 {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {1,3,5,2,4}), oddEvenList(ListNode.fromArray(new int[] {1,2,3,4,5})));
    assertEquals(ListNode.fromArray(new int[] {2,3,6,7,1,5,4}), oddEvenList(ListNode.fromArray(new int[] {2,1,3,5,6,4,7})));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode evenHead = head.next;
    ListNode odd = head;
    ListNode even = evenHead;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }
}
