package Coding_Interview_Patterns_ByteByteGo.ch1_two_pointers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/is-palindrome-valid">Is Palindrome Valid</a>
 */
public class IsPalindromeValid {

  public static void main(String[] args) {
    assertTrue(isPalindromeValid("a dog! a panic in a pagoda."));
    assertFalse(isPalindromeValid("abc123"));
    assertTrue(isPalindromeValid(""));
    assertTrue(isPalindromeValid("a"));
    assertTrue(isPalindromeValid("aa"));
    assertFalse(isPalindromeValid("ab"));
    assertTrue(isPalindromeValid("!, (?)"));
    assertTrue(isPalindromeValid("12.02.2021"));
    assertFalse(isPalindromeValid("21.02.2021"));
    assertFalse(isPalindromeValid("hello, world!"));
  }

  /**
   * Approach: Two Pointers (Inward Traversal) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isPalindromeValid(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
