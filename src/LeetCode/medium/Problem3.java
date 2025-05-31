//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
// */
//public class Problem3 {
//
//  public static void main(String[] args) {
//    assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
//    assertEquals(1, lengthOfLongestSubstring("bbbbb"));
//    assertEquals(3, lengthOfLongestSubstring("pwwkew"));
//  }
//
//  /**
//   * Approach: Sliding Window (Optimized) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(k) <-> k is the number of distinct characters <br>
//   */
//  public static int lengthOfLongestSubstring(String s) {
//    int answer = 0;
//    Map<Character, Integer> charToNextIndex = new HashMap<>(); // index after current character
//    for (int left = 0, right = 0; right < s.length(); right++) {
//      char rChar = s.charAt(right);
//      if (charToNextIndex.containsKey(rChar)) {
//        left = Math.max(charToNextIndex.get(rChar), left);
//      }
//      charToNextIndex.put(rChar, right + 1);
//      answer = Math.max(answer, right - left + 1);
//    }
//    return answer;
//  }
//
////  /**
////   * Approach: Sliding Window <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(k) <-> k is the number of distinct characters <br>
////   */
////  public static int lengthOfLongestSubstring(String s) {
////    int answer = 0;
////    Map<Character, Integer> charFrequencies = new HashMap<>();
////    for (int left = 0, right = 0; right < s.length(); right++) {
////      char rChar = s.charAt(right);
////      charFrequencies.put(rChar, charFrequencies.getOrDefault(rChar, 0) + 1);
////      while (charFrequencies.get(rChar) > 1) {
////        char lChar = s.charAt(left);
////        charFrequencies.put(lChar, charFrequencies.get(lChar) - 1);
////        left++;
////      }
////      answer = Math.max(answer, right - left + 1);
////    }
////    return answer;
////  }
////
////  /**
////   * Approach: Brute Force -> Time Limit Exceeded <br>
////   * Time Complexity: O(n^3) <br>
////   * Space Complexity: O(k) <-> k is the number of distinct characters <br>
////   */
////  public static int lengthOfLongestSubstring(String s) {
////    int answer = 0;
////    int n = s.length();
////    for (int i = 0; i < n; i++) {
////      for (int j = i; j < n; j++) {
////        if (checkRepetition(s, i, j)) {
////          answer = Math.max(answer, j - i + 1);
////        }
////      }
////    }
////    return answer;
////  }
////
////  /**
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(k) <-> k is the number of distinct characters <br>
////   */
////  private static boolean checkRepetition(String s, int start, int end) {
////    Set<Character> chars = new HashSet<>();
////    for (int i = start; i <= end; i++) {
////      if (!chars.add(s.charAt(i))) {
////        return false;
////      }
////    }
////    return true;
////  }
//}
