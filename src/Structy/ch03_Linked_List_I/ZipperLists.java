//package Structy.ch03_Linked_List_I;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import Structy.common.ListNode;
//
///**
// * <a href="https://structy.net/problems/zipper-lists">Zipper Lists</a>
// */
//public class ZipperLists {
//
//  public static void main(String[] args) {
//    assertEquals(
//        ListNode.fromArray(new String[] {"a", "1"}),
//        zipperLists(
//            ListNode.fromArray(new String[] {"a"}),
//            ListNode.fromArray(new String[] {"1"})));
//
////    assertEquals(
////        ListNode.fromArray(new String[] {"a", "x", "b", "y", "c", "z"}),
////        zipperLists(
////            ListNode.fromArray(new String[] {"a", "b", "c"}),
////            ListNode.fromArray(new String[] {"x", "y", "z"})));
////
////    assertEquals(
////        ListNode.fromArray(new String[] {"a", "x", "b", "y", "c", "z", "d", "e", "f"}),
////        zipperLists(
////            ListNode.fromArray(new String[] {"a", "b", "c", "d", "e", "f"}),
////            ListNode.fromArray(new String[] {"x", "y", "z"})));
////
////    assertEquals(
////        ListNode.fromArray(new String[] {"s", "1", "t", "2", "3", "4"}),
////        zipperLists(
////            ListNode.fromArray(new String[] {"s", "t"}),
////            ListNode.fromArray(new String[] {"1", "2", "3", "4"})));
//
////    assertEquals(
////        ListNode.fromArray(new String[] {"w", "1", "2", "3"}),
////        zipperLists(
////            ListNode.fromArray(new String[] {"w"}),
////            ListNode.fromArray(new String[] {"1", "2", "3"})));
//
////    assertEquals(
////        ListNode.fromArray(new String[] {"1", "w", "2", "3"}),
////        zipperLists(
////            ListNode.fromArray(new String[] {"1", "2", "3"}),
////            ListNode.fromArray(new String[] {"w"})));
//  }
//
//  /**
//   * Approach: Recursive
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static <T> ListNode<T> zipperLists1(ListNode<T> head1, ListNode<T> head2) {
//
//    return null;
//  }
//
//  /**
//   * Approach: Iterative
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static <T> ListNode<T> zipperLists(ListNode<T> head1, ListNode<T> head2) {
//    ListNode<T> head = new ListNode<>(null);
//    head.next = head1;
//
//    ListNode<T> prev1 = null;
//    ListNode<T> curr1 = head1;
//    ListNode<T> curr2 = head2;
//    while (curr1 != null && curr2 != null) {
//      ListNode<T> next1 = curr1.next;
//      ListNode<T> next2 = curr2.next;
//      curr1.next = curr2;
//      curr2.next = next1;
//      prev1 = curr1;
//      curr1 = next1;
//      curr2 = next2;
//    }
//    if (curr2 != null) {
//      prev1.next.next = curr2;
//    }
//    return head.next;
//  }
//}
