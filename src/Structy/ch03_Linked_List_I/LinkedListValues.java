package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

import Structy.common.ListNode;
import java.util.*;

/**
 * <a href="https://structy.net/problems/linked-list-values">Linked List Values</a>
 */
public class LinkedListValues {

  public static void main(String[] args) {
    assertEquals(
        new ArrayList<>(List.of("a", "b", "c", "d")),
        linkedListValues(ListNode.fromArray(new String[] {"a", "b", "c", "d"})));

    assertEquals(
        new ArrayList<>(List.of("x", "y")),
        linkedListValues(ListNode.fromArray(new String[] {"x", "y"})));

    assertEquals(
        new ArrayList<>(List.of("q")),
        linkedListValues(ListNode.fromArray(new String[] {"q"})));

    assertEquals(
        new ArrayList<>(List.of()),
        linkedListValues(ListNode.fromArray(null)));
  }

  /**
   * Approach: Recursive
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<String> linkedListValues(ListNode<String> head) {
    List<String> values = new ArrayList<>();
    linkedListValuesHelper(head, values);
    return values;
  }

  private static void linkedListValuesHelper(ListNode<String> head, List<String> values) {
    if (head == null) {
      return;
    }
    values.add(head.val);
    linkedListValuesHelper(head.next, values);
  }

//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<String> linkedListValues(ListNode<String> head) {
//    List<String> values = new ArrayList<>();
//    ListNode<String> curr = head;
//    while (curr != null) {
//      values.add(curr.val);
//      curr = curr.next;
//    }
//    return values;
//  }
}
