package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">242. Valid Anagram</a>
 */
public class Problem242 {

  public static void main(String[] args) {
    assertTrue(isAnagram("anagram", "nagaram"));
    assertFalse(isAnagram("rat", "car"));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> counter = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
      counter.put(t.charAt(i), counter.getOrDefault(t.charAt(i), 0) - 1);
    }
    for (int count : counter.values()) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

//  /**
//   * Approach: Array Counter <br>
//   * Time Complexity: O(n + K) <-> K is the number of distinct characters <br>
//   * Space Complexity: O(K) <br>
//   */
//  public static boolean isAnagram(String s, String t) {
//    if (s.length() != t.length()) {
//      return false;
//    }
//    int[] counter = new int[26];
//    for (int i = 0; i < s.length(); i++) {
//      counter[s.charAt(i) - 'a']++;
//      counter[t.charAt(i) - 'a']--;
//    }
//    for (int count : counter) {
//      if (count != 0) {
//        return false;
//      }
//    }
//    return true;
//  }
//
//  /**
//   * Approach: Sorting <br>
//   * Time Complexity: O(n log(n)) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean isAnagram(String s, String t) {
//    if (s.length() != t.length()) {
//      return false;
//    }
//    char[] str1 = s.toCharArray();
//    char[] str2 = t.toCharArray();
//    Arrays.sort(str1);
//    Arrays.sort(str2);
//    return Arrays.equals(str1, str2);
//  }
}
