package Structy.ch05_Two_Pointer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/premium/is-palindrome">Is Palindrome</a>
 */
public class IsPalindrome {

  public static void main(String[] args) {
    assertTrue(isPalindrome("pop"));
    assertTrue(isPalindrome("kayak"));
    assertFalse(isPalindrome("pops"));
    assertFalse(isPalindrome("boot"));
    assertTrue(isPalindrome("rotator"));
    assertFalse(isPalindrome("abcbca"));
    assertTrue(isPalindrome(""));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
