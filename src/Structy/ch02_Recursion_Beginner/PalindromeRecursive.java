package Structy.ch02_Recursion_Beginner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://structy.net/problems/premium/palindrome-recursive">Palindrome Recursive</a>
 */
public class PalindromeRecursive {

  public static void main(String[] args) {
    assertTrue(palindrome("pop"));
    assertTrue(palindrome("kayak"));
    assertFalse(palindrome("pops"));
    assertFalse(palindrome("boot"));
    assertTrue(palindrome("rotator"));
    assertFalse(palindrome("abcbca"));
    assertTrue(palindrome(""));
  }

  /**
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static boolean palindrome(String s) {
    if (s.length() <= 1) {
      return true;
    }
    if (s.charAt(0) != s.charAt(s.length() - 1)) {
      return false;
    }
    return palindrome(s.substring(1, s.length() - 1));
  }
}
