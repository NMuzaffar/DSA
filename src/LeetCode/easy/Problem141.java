package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 */
public class Problem141 {

  public static void main(String[] args) {
    assertTrue(hasCycle(ListNode.fromArray(new int[] {3,2,0,-4}, 1)));
    assertTrue(hasCycle(ListNode.fromArray(new int[] {1,2}, 0)));
    assertFalse(hasCycle(ListNode.fromArray(new int[] {1}, -1)));
  }

  /**
   * Approach: Fast & Slow Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
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
//  public static boolean hasCycle(ListNode head) {
//    Set<ListNode> nodesVisited = new HashSet<>();
//    ListNode currentNode = head;
//    while (currentNode != null) {
//      if (!nodesVisited.add(currentNode)) {
//        return true;
//      }
//      currentNode = currentNode.next;
//    }
//    return false;
//  }
}
