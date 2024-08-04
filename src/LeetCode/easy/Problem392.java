package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">Is Subsequence</a>
 */
public class Problem392 {

  public static void main(String[] args) {
    assertTrue(isSubsequence("abc", "ahbgdc"));
    assertFalse(isSubsequence("axc","ahbgdc"));
  }

  /**
   * Approach: Two Pointers
   * Time complexity: O(|T|)
   * Space complexity: O(1)
   */
  public static boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) return true; // An empty string is always a subsequence
    if (s.length() > t.length()) return false; // s cannot be a subsequence of t if s is longer

    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }
}
