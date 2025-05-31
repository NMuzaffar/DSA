//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import LeetCode.common.ListNode;
//
///**
// * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>
// */
//public class Problem876 {
//
//  public static void main(String[] args) {
//    assertEquals(ListNode.fromArray(new int[] {3,4,5}), middleNode(ListNode.fromArray(new int[] {1,2,3,4,5})));
//    assertEquals(ListNode.fromArray(new int[] {4,5,6}), middleNode(ListNode.fromArray(new int[] {1,2,3,4,5,6})));
//  }
//
//  /**
//   * Approach: Fast & Slow Pointers <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static ListNode middleNode(ListNode head) {
//    ListNode slow = head;
//    ListNode fast = head;
//    while (fast != null && fast.next != null) {
//      slow = slow.next;
//      fast = fast.next.next;
//    }
//    return slow;
//  }
//
////  /**
////   * Approach: Array Output <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static ListNode middleNode(ListNode head) {
////    ListNode[] nodesArray = new ListNode[100];
////    int length = 0;
////    while (head != null) {
////      nodesArray[length++] = head;
////      head = head.next;
////    }
////    return nodesArray[length / 2];
////  }
//}
