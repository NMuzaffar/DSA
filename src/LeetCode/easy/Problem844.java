package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">844. Backspace String Compare</a>
 */
public class Problem844 {

  public static void main(String[] args) {
    assertTrue(backspaceCompare("ab#c", "ad#c"));
    assertTrue(backspaceCompare("ab##", "c#d#"));
    assertFalse(backspaceCompare("a#c", "b"));
    assertTrue(backspaceCompare("y#fo##f", "y#f#o##f"));
  }

  /**
   * Approach: Stack (StringBuilder) <br>
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(n + m) <br>
   */
  public static boolean backspaceCompare(String s, String t) {
    return removeBackspaces(s).equals(removeBackspaces(t));
  }

  private static String removeBackspaces(String str) {
    StringBuilder charStack = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (c != '#') {
        charStack.append(c);
      } else if (!charStack.isEmpty()) {
        charStack.deleteCharAt(charStack.length() - 1);
      }
    }
    return charStack.toString();
  }
}
