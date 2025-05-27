package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">1047. Remove All Adjacent Duplicates In String</a>
 */
public class Problem1047 {

  public static void main(String[] args) {
    assertEquals("ca", removeDuplicates("abbaca"));
    assertEquals("ay", removeDuplicates("azxxzy"));
  }

  /**
   * Approach: Stack <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String removeDuplicates(String s) {
    Deque<Character> charStack = new ArrayDeque<>();
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (!charStack.isEmpty() && charStack.getFirst() == c) {
        charStack.removeFirst();
      } else {
        charStack.addFirst(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!charStack.isEmpty()) {
      sb.append(charStack.removeFirst());
    }
    return sb.toString();
  }

//  /**
//   * Approach: Stack (StringBuilder) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static String removeDuplicates(String s) {
//    StringBuilder charStack = new StringBuilder();
//    for (char c : s.toCharArray()) {
//      if (!charStack.isEmpty() && charStack.charAt(charStack.length() - 1) == c) {
//        charStack.deleteCharAt(charStack.length() - 1);
//      } else {
//        charStack.append(c);
//      }
//    }
//    return charStack.toString();
//  }
}
