package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">392. Is Subsequence</a>
 */
public class Problem392 {

  public static void main(String[] args) {
    assertTrue(isSubsequence("abc", "ahbgdc"));
    assertFalse(isSubsequence("axc","ahbgdc"));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(|T|) <-> |T| is the length of the target string <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isSubsequence(String s, String t) {
    // An empty string is always a subsequence
    if (s.isEmpty()) {
      return true;
    }
    // S cannot be a subsequence of T if S is longer
    if (s.length() > t.length())
      return false;
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
