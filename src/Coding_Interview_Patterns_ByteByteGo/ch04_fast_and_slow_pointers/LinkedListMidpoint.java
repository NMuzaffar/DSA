package Coding_Interview_Patterns_ByteByteGo.ch04_fast_and_slow_pointers;

import static org.junit.jupiter.api.Assertions.*;

import Coding_Interview_Patterns_ByteByteGo.common.ListNode;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/fast-and-slow-pointers/linked-list-midpoint">Linked List Midpoint</a>
 */
public class LinkedListMidpoint {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {4,7,3}), linkedListMidpoint(ListNode.fromArray(new int[] {1,2,4,7,3})));
    assertEquals(ListNode.fromArray(new int[] {4,7}), linkedListMidpoint(ListNode.fromArray(new int[] {1,2,4,7})));
  }

  /**
   * Approach: Fast & Slow Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode linkedListMidpoint(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    // When the fast pointer reaches the end of the list, the slow
    // pointer will be at the midpoint of the linked list.
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
