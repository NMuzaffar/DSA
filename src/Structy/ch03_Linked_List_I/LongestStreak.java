package Structy.ch03_Linked_List_I;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/premium/longest-streak">Longest Streak</a>
 */
public class LongestStreak {

  public static void main(String[] args) {
    assertEquals(3, longestStreak(Node.fromArray(new Integer[] {5, 5, 7, 7, 7, 6})));
    assertEquals(4, longestStreak(Node.fromArray(new Integer[] {3, 3, 3, 3, 9, 9})));
    assertEquals(3, longestStreak(Node.fromArray(new Integer[] {9, 9, 1, 9, 9, 9})));
    assertEquals(2, longestStreak(Node.fromArray(new Integer[] {5, 5})));
    assertEquals(1, longestStreak(Node.fromArray(new Integer[] {4})));
    assertEquals(0, longestStreak(null));
  }

  /**
   * Approach: Iterative
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static <T> int longestStreak(Node<T> head) {
    Node<T> curr = head;
    int maxStreak = 0;
    int currStreak = 0;
    T prevVal = null;
    while (curr != null) {
      if (curr.val == prevVal) {
        currStreak++;
      } else {
        currStreak = 1;
      }
      if (currStreak > maxStreak) {
        maxStreak = currStreak;
      }
      prevVal = curr.val;
      curr = curr.next;
    }
    return maxStreak;
  }
}
