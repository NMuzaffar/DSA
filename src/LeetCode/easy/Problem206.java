package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 */
public class Problem206 {

  public static void main(String[] args) {
    assertEquals(ListNode.fromArray(new int[] {5,4,3,2,1}), reverseList(ListNode.fromArray(new int[] {1,2,3,4,5})));
    assertEquals(ListNode.fromArray(new int[] {2,1}), reverseList(ListNode.fromArray(new int[] {1,2})));
    assertEquals(ListNode.fromArray(new int[] {}), reverseList(ListNode.fromArray(new int[] {})));
  }

  /**
   * Approach: Reverse Linked List (Classic Recursion) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode reversedSubList = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reversedSubList;
  }

//  /**
//   * Approach: Reverse Linked List (Tail Recursion) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static ListNode reverseList(ListNode head) {
//    return reverseListTailRecursive(head, null);
//  }
//
//  private static ListNode reverseListTailRecursive(ListNode currNode, ListNode prevNode) {
//    if (currNode == null) {
//      return prevNode;
//    }
//    ListNode nextNode = currNode.next;
//    currNode.next = prevNode;
//    return reverseListTailRecursive(nextNode, currNode);
//  }

//  /**
//   * Approach: Reverse Linked List (Iterative) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static ListNode reverseList(ListNode head) {
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
