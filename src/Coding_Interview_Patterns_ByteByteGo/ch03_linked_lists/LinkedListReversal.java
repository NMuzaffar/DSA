package Coding_Interview_Patterns_ByteByteGo.ch03_linked_lists;

import static org.junit.jupiter.api.Assertions.*;

import Coding_Interview_Patterns_ByteByteGo.common.ListNode;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/linked-lists/linked-list-reversal">Linked List Reversal</a>
 */
public class LinkedListReversal {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {3,7,4,2,1}), linkedListReversal(ListNode.fromArray(new int[] {1,2,4,7,3})));
  }

  /**
   * Approach: Recursive <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static ListNode linkedListReversal(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = linkedListReversal(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

//  /**
//   * Approach: Iterative <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static ListNode linkedListReversal(ListNode head) {
//    ListNode currNode = head;
//    ListNode prevNode = null;
//    while (currNode != null) {
//      ListNode nextNode = currNode.next;
//      currNode.next = prevNode;
//      prevNode = currNode;
//      currNode = nextNode;
//    }
//    return prevNode;
//  }
}
