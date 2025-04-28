package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-balloons/">1189. Maximum Number of Balloons</a>
 */
public class Problem1189 {

  public static void main(String[] args) {
    assertEquals(1, maxNumberOfBalloons("nlaebolko"));
    assertEquals(2, maxNumberOfBalloons("loonbalxballpoon"));
    assertEquals(0, maxNumberOfBalloons("leetcode"));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n + M) <-> M equals the length of pattern, e.g. 'balloon' <br>
   * Space Complexity: O(1) <br>
   */
  public static int maxNumberOfBalloons(String text) {
    String pattern = "balloon";
    Map<Character, Integer> patternCharCounts = new HashMap<>();
    Map<Character, Integer> textCharCounts = new HashMap<>();
    for (char c : text.toCharArray()) { // O(n)
      textCharCounts.put(c, textCharCounts.getOrDefault(c, 0) + 1);
    }
    for (char c : pattern.toCharArray()) { // O(M)
      patternCharCounts.put(c, patternCharCounts.getOrDefault(c, 0) + 1);
    }
    int answer = Integer.MAX_VALUE;
    for (char c : patternCharCounts.keySet()) {
      if (textCharCounts.containsKey(c)) {
        answer = Math.min(answer, textCharCounts.get(c) / patternCharCounts.get(c));
      } else {
        return 0;
      }
    }
    return answer;
  }

//  /**
//   * Approach: Array Counter <br>
//   * Time Complexity: O(n + M) <-> M equals the length of pattern, e.g. 'balloon' <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int maxNumberOfBalloons(String text) {
//    String pattern = "balloon";
//    int[] patternCharCounts = new int[26];
//    int[] textCharCounts = new int[26];
//    for (char c : text.toCharArray()) { // O(n)
//      textCharCounts[c - 'a']++;
//    }
//    for (char c : pattern.toCharArray()) { // O(M)
//      patternCharCounts[c - 'a']++;
//    }
//    int answer = Integer.MAX_VALUE;
//    for (int i = 0; i < 26; i++) {
//      if (patternCharCounts[i] > 0) {
//        answer = Math.min(answer, textCharCounts[i] / patternCharCounts[i]);
//      }
//    }
//    return answer;
//  }
//
//  /**
//   * Approach: Counting Characters <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int maxNumberOfBalloons(String text) {
//    int bCount = 0, aCount = 0, lCount = 0, oCount = 0, nCount = 0;
//    for (char c : text.toCharArray()) {
//      if (c == 'b') {
//        bCount++;
//      } else if (c == 'a') {
//        aCount++;
//      } else if (c == 'l') {
//        lCount++;
//      } else if (c == 'o') {
//        oCount++;
//      } else if (c == 'n') {
//        nCount++;
//      }
//    }
//    lCount /= 2;
//    oCount /= 2;
//    return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
//  }
}
