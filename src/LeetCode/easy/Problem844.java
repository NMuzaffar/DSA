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
   * Approach: Two Pointers <br>
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean backspaceCompare(String s, String t) {
    int sourcePtr = s.length() - 1;
    int targetPtr = t.length() - 1;
    int skipS = 0;
    int skipT = 0;
    while (sourcePtr >= 0 || targetPtr >= 0) {
      while (sourcePtr >= 0) {
        if (s.charAt(sourcePtr) == '#') {
          skipS++;
          sourcePtr--;
        } else if (skipS > 0) {
          skipS--;
          sourcePtr--;
        } else break;
      }
      while (targetPtr >= 0) {
        if (t.charAt(targetPtr) == '#') {
          skipT++;
          targetPtr--;
        } else if (skipT > 0) {
          skipT--;
          targetPtr--;
        } else break;
      }
      if (sourcePtr >= 0 && targetPtr >= 0 && s.charAt(sourcePtr) != t.charAt(targetPtr)) {
        return false;
      }
      if ((sourcePtr >= 0) != (targetPtr >= 0)) {
        return false;
      }
      sourcePtr--;
      targetPtr--;
    }
    return true;
  }

//  /**
//   * Approach: Stack (StringBuilder) <br>
//   * Time Complexity: O(n + m) <br>
//   * Space Complexity: O(n + m) <br>
//   */
//  public static boolean backspaceCompare(String s, String t) {
//    return removeBackspaces(s).equals(removeBackspaces(t));
//  }
//
//  private static String removeBackspaces(String str) {
//    StringBuilder charStack = new StringBuilder();
//    for (char c : str.toCharArray()) {
//      if (c != '#') {
//        charStack.append(c);
//      } else if (!charStack.isEmpty()) {
//        charStack.deleteCharAt(charStack.length() - 1);
//      }
//    }
//    return charStack.toString();
//  }
}
