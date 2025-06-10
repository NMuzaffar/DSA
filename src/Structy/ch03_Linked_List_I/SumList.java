package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

import Structy.common.ListNode;

/**
 * <a href="https://structy.net/problems/sum-list">Sum List</a>
 */
public class SumList {

  public static void main(String[] args) {
    assertEquals(19, sumList(ListNode.fromArray(new Integer[] {2, 8, 3, -1, 7})));
    assertEquals(42, sumList(ListNode.fromArray(new Integer[] {38, 4})));
    assertEquals(100, sumList(ListNode.fromArray(new Integer[] {100})));
    assertEquals(0, sumList(ListNode.fromArray(null)));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int sumList(ListNode<Integer> head) {
    if (head == null) {
      return 0;
    }
    return head.val + sumList(head.next);
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int sumList(ListNode<Integer> head) {
//    int sum = 0;
//    ListNode<Integer> curr = head;
//    while (curr != null) {
//      sum += curr.val;
//      curr = curr.next;
//    }
//    return sum;
//  }
}
