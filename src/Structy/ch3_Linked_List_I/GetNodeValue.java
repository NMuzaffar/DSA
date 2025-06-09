package Structy.ch3_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

import Structy.common.ListNode;

/**
 * <a href="https://structy.net/problems/get-node-value">Get Node Value</a>
 */
public class GetNodeValue {

  public static void main(String[] args) {
    assertEquals("c", getNodeValue(ListNode.fromArray(new String[] {"a", "b", "c", "d"}), 2));
    assertEquals("d", getNodeValue(ListNode.fromArray(new String[] {"a", "b", "c", "d"}), 3));
    assertEquals(null, getNodeValue(ListNode.fromArray(new String[] {"a", "b", "c", "d"}), 7));
    assertEquals("banana", getNodeValue(ListNode.fromArray(new String[] {"banana", "mango"}), 0));
    assertEquals("mango", getNodeValue(ListNode.fromArray(new String[] {"banana", "mango"}), 1));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static <T> T getNodeValue(ListNode<T> head, int index) {
    if (head == null) {
      return null;
    }
    if (index == 0) {
      return head.val;
    }
    return getNodeValue(head.next, index - 1);
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> T getNodeValue(ListNode<T> head, int index) {
//    ListNode<T> curr = head;
//    int currIndex = 0;
//    while (curr != null) {
//      if (currIndex == index) {
//        return curr.val;
//      }
//      curr = curr.next;
//      currIndex += 1;
//    }
//    return null;
//  }
}
