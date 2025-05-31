//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import LeetCode.common.ListNode;
//
///**
// * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">83. Remove Duplicates from Sorted List</a>
// */
//public class Problem83 {
//
//  public static void main(String[] args) {
//    assertEquals(ListNode.fromArray(new int[] {1,2}), deleteDuplicates(ListNode.fromArray(new int[] {1,1,2})));
//    assertEquals(ListNode.fromArray(new int[] {1,2,3}), deleteDuplicates(ListNode.fromArray(new int[] {1,1,2,3,3})));
//    assertEquals(ListNode.fromArray(new int[] {1}), deleteDuplicates(ListNode.fromArray(new int[] {1,1,1})));
//  }
//
//  /**
//   * Approach: Straight-Forward Approach <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static ListNode deleteDuplicates(ListNode head) {
//    ListNode currentNode = head;
//    while (currentNode != null && currentNode.next != null) {
//      if (currentNode.val == currentNode.next.val) {
//        currentNode.next = currentNode.next.next;
//      } else {
//        currentNode = currentNode.next;
//      }
//    }
//    return head;
//  }
//}
