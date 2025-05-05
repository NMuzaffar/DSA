package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">383. Ransom Note</a>
 */
public class Problem383 {

  public static void main(String[] args) {
    assertFalse(canConstruct("a", "b"));
    assertFalse(canConstruct("aa", "ab"));
    assertTrue(canConstruct("aa", "aab"));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(m) <br>
   * Space Complexity: O(k) <-> k is the number of distinct characters (e.g. 26) <br>
   */
  public static boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
    Map<Character, Integer> magazineLetters = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      magazineLetters.put(c, magazineLetters.getOrDefault(c, 0) + 1);
    }
    for (char c : ransomNote.toCharArray()) {
      int currentCount = magazineLetters.getOrDefault(c, 0);
      if (currentCount == 0) {
        return false;
      }
      magazineLetters.put(c, currentCount - 1);
    }
    return true;
  }

//  /**
//   * Approach: Array Counter <br>
//   * Time Complexity: O(m) <br>
//   * Space Complexity: O(k) <-> k is the number of distinct characters (e.g. 26) <br>
//   */
//  public static boolean canConstruct(String ransomNote, String magazine) {
//    if (ransomNote.length() > magazine.length()) {
//      return false;
//    }
//    int[] magazineLetters = new int[26];
//    for (char c : magazine.toCharArray()) {
//      magazineLetters[c - 'a']++;
//    }
//    for (char c : ransomNote.toCharArray()) {
//      if (magazineLetters[c - 'a'] == 0) {
//        return false;
//      }
//      magazineLetters[c - 'a']--;
//    }
//    return true;
//  }
//
//  /**
//   * Approach: Simulation <br>
//   * Time Complexity: O(n * m) <br>
//   * Space Complexity: O(m) <br>
//   */
//  public static boolean canConstruct(String ransomNote, String magazine) {
//    if (ransomNote.length() > magazine.length()) {
//      return false;
//    }
//    for (char c : ransomNote.toCharArray()) { // O(n)
//      int matchingIndex = magazine.indexOf(c); // O(m)
//      if (matchingIndex == -1) {
//        return false;
//      }
//      magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1); // O(m)
//    }
//    return true;
//  }
}
