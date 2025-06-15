package Coding_Interview_Patterns_ByteByteGo.ch03_linked_lists;

import static org.junit.jupiter.api.Assertions.*;

import Coding_Interview_Patterns_ByteByteGo.common.ListNode;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/linked-lists/remove-the-kth-last-node-from-a-linked-list">Remove the Kth Last Node From a Linked List</a>
 */
public class RemoveKthLastNode {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {1,2,4,3}), removeKthLastNode(ListNode.fromArray(new int[] {1,2,4,7,3}), 2));
    assertEquals(ListNode.fromArray(new int[] {}), removeKthLastNode(ListNode.fromArray(new int[] {1}), 1));
    assertEquals(ListNode.fromArray(new int[] {1,4,7,3}), removeKthLastNode(ListNode.fromArray(new int[] {1,2,4,7,3}), 4));
    assertEquals(ListNode.fromArray(new int[] {1,2,3,4,5}), removeKthLastNode(ListNode.fromArray(new int[] {1,2,3,4,5}), 6));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static ListNode removeKthLastNode(ListNode head, int k) {
    // A dummy node to ensure there's a node before 'head' in case we need to remove the head node.
    ListNode sentinel = new ListNode(-1);
    sentinel.next = head;
    ListNode trailer = sentinel;
    ListNode leader = sentinel;
    // Advance 'leader' k steps ahead.
    for (int i = 0; i < k; i++) {
      leader = leader.next;
      // If k is larger than the length of the linked list, no node needs to be removed.
      if (leader == null) {
        return head;
      }
    }
    // Move 'leader' to the end of the linked list, keeping 'trailer' k nodes behind.
    while (leader.next != null) {
      leader = leader.next;
      trailer = trailer.next;
    }
    // Remove the kth node from the end.
    trailer.next = trailer.next.next;
    return sentinel.next;
  }
}
