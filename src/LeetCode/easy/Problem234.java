package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">234. Palindrome Linked List</a>
 */
public class Problem234 {

  public static void main(String[] args) {
    assertTrue(isPalindrome(ListNode.fromArray(new int[] {1,2,2,1})));
    assertFalse(isPalindrome(ListNode.fromArray(new int[] {1,2})));
    assertFalse(isPalindrome(ListNode.fromArray(new int[] {1,1,2,1})));
    assertTrue(isPalindrome(ListNode.fromArray(new int[] {1,2,3,3,2,1})));
  }

  /**
   * Approach: Reverse Second Half (In-place) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode mid = findMiddle(head);
    ListNode secondHalfStart = reverseList(mid.next);
    // Compare the first half and the reversed second half of the list
    boolean result = true;
    ListNode ptr1 = head;
    ListNode ptr2 = secondHalfStart;
    while (ptr2 != null) {
      if (ptr1.val != ptr2.val) {
        return false;
      }
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    mid.next = reverseList(secondHalfStart);
    return result;
  }

  private static ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null) {
      ListNode nextNode = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextNode;
    }
    return prev;
  }

  private static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
