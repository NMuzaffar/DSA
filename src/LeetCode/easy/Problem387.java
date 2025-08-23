package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">387. First Unique Character in a String</a>
 */
public class Problem387 {

  public static void main(String[] args) {
    assertEquals(0, firstUniqChar("leetcode"));
    assertEquals(2, firstUniqChar("loveleetcode"));
    assertEquals(-1, firstUniqChar("aabb"));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int firstUniqChar(String s) {
    int[] charFreqs = new int[26];
    for (char c : s.toCharArray()) {
      charFreqs[c - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charFreqs[c - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
