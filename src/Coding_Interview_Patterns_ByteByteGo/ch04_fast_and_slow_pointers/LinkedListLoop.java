package Coding_Interview_Patterns_ByteByteGo.ch04_fast_and_slow_pointers;

import static org.junit.jupiter.api.Assertions.*;

import Coding_Interview_Patterns_ByteByteGo.common.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/fast-and-slow-pointers/linked-list-loop">Linked List Loop</a>
 */
public class LinkedListLoop {

  public static void main(String[] args) {
    assertTrue(linkedListLoop(ListNode.fromArray(new int[] {0,1,2,3,4,5}, 2)));
    assertFalse(linkedListLoop(ListNode.fromArray(new int[] {0,1,2,3,4,5}, -1)));
  }

  /**
   * Approach: Floyd's Cycle Detection (Fast & Slow Pointers) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean linkedListLoop(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    // Check both 'fast' and 'fast.next' to avoid null pointer
    // exceptions when we perform 'fast.next' and 'fast.next.next'.
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

//  /**
//   * Approach: Hash Set <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean linkedListLoop(ListNode head) {
//    Set<ListNode> visited = new HashSet<>();
//    ListNode curr = head;
//    while (curr != null) {
//      // Cycle detected if the current node has already been visited.
//      if (!visited.add(curr)) {
//        return true;
//      }
//      curr = curr.next;
//    }
//    return false;
//  }
}
