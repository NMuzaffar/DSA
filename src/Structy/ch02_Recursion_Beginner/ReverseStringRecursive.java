package Structy.ch02_Recursion_Beginner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/premium/reverse-string-recursive">Reverse String Recursive</a>
 */
public class ReverseStringRecursive {

  public static void main(String[] args) {
    assertEquals("olleh", reverseString("hello"));
    assertEquals("gfedcba", reverseString("abcdefg"));
    assertEquals("hctawpots", reverseString("stopwatch"));
    assertEquals("", reverseString(""));
  }

  /**
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static String reverseString(String s) {
    if (s.isEmpty()) {
      return "";
    }
    return reverseString(s.substring(1)) + s.charAt(0);
  }
}
