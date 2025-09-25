package Structy.ch05_Two_Pointer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://structy.net/problems/premium/is-subsequence">Is Subsequence</a>
 */
public class IsSubsequence {

  public static void main(String[] args) {
    assertTrue(isSubsequence("bde", "abcdef"));
    assertFalse(isSubsequence("bda", "abcdef"));
    assertTrue(isSubsequence("ser", "super"));
    assertFalse(isSubsequence("serr", "super"));
    assertTrue(isSubsequence("ama", "camera"));
    assertTrue(isSubsequence("unfun", "unfortunate"));
    assertFalse(isSubsequence("riverbed", "river"));
    assertTrue(isSubsequence("river", "riverbed"));
  }

  /**
   * Time Complexity: O(m) <-> 'm' is the length of the 'string1' <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isSubsequence(String string1, String string2) {
    if (string1.length() > string2.length()) {
      return false;
    }
    int i = 0;
    int j = 0;
    while (i < string1.length() && j < string2.length()) {
      if (string1.charAt(i) == string2.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == string1.length();
  }
}
