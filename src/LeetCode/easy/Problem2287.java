//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <a href="https://leetcode.com/problems/rearrange-characters-to-make-target-string/">2287. Rearrange Characters to Make Target String</a>
// */
//public class Problem2287 {
//
//  public static void main(String[] args) {
//    assertEquals(2, rearrangeCharacters("ilovecodingonleetcode", "code"));
//    assertEquals(1, rearrangeCharacters("abcba", "abc"));
//    assertEquals(1, rearrangeCharacters("abbaccaddaeea", "aaaaa"));
//  }
//
//  /**
//   * Approach: Hash Map <br>
//   * Time Complexity: O(N + M) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int rearrangeCharacters(String s, String target) {
//    Map<Character, Integer> strCharCounts = new HashMap<>();
//    Map<Character, Integer> targetCharCounts = new HashMap<>();
//    for (char c : s.toCharArray()) { // O(n)
//      strCharCounts.put(c, strCharCounts.getOrDefault(c, 0) + 1);
//    }
//    for (char c : target.toCharArray()) { // O(M)
//      targetCharCounts.put(c, targetCharCounts.getOrDefault(c, 0) + 1);
//    }
//    int answer = Integer.MAX_VALUE;
//    for (char c : targetCharCounts.keySet()) {
//      if (strCharCounts.containsKey(c)) {
//        answer = Math.min(answer, strCharCounts.get(c) / targetCharCounts.get(c));
//      } else {
//        return 0;
//      }
//    }
//    return answer;
//  }
//
////  /**
////   * Approach: Array Counter <br>
////   * Time Complexity: O(N + M) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int rearrangeCharacters(String s, String target) {
////    int[] strCharCounts = new int[26];
////    int[] targetCharCounts = new int[26];
////    for (char c : s.toCharArray()) { // O(n)
////      strCharCounts[c - 'a']++;
////    }
////    for (char c : target.toCharArray()) { // O(M)
////      targetCharCounts[c - 'a']++;
////    }
////    int answer = Integer.MAX_VALUE;
////    for (int i = 0; i < 26; i++) {
////      if (targetCharCounts[i] > 0) {
////        answer = Math.min(answer, strCharCounts[i] / targetCharCounts[i]);
////      }
////    }
////    return answer;
////  }
//}
