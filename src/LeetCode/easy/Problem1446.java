package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/consecutive-characters/">1446. Consecutive Characters</a>
 */
public class Problem1446 {

  public static void main(String[] args) {
    assertEquals(2, maxPower("leetcode"));
    assertEquals(5, maxPower("abbcccddddeeeeedcba"));
  }

  /**
   * Approach: One Pass <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int maxPower(String s) {
    int maxCount = 0;
    int count = 0;
    int previousChar = ' ';
    for (char c : s.toCharArray()) {
      if (c == previousChar) {
        count++;
      } else {
        maxCount = Math.max(maxCount, count);
        count = 1;
      }
      previousChar = c;
    }
    return Math.max(maxCount, count);
  }
}
