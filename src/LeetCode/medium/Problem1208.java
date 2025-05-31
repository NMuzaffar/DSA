//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/">1208. Get Equal Substrings Within Budget</a>
// */
//public class Problem1208 {
//
//  public static void main(String[] args) {
//    assertEquals(3, equalSubstring("abcd", "bcdf", 3));
//    assertEquals(1, equalSubstring("abcd", "cdef", 3));
//    assertEquals(1, equalSubstring("abcd", "acde", 0));
//  }
//
//  /**
//   * Approach: Sliding Window <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int equalSubstring(String s, String t, int maxCost) {
//    int answer = 0;
//    int currCost = 0;
//    for (int left = 0, right = 0; right < s.length(); right++) {
//      currCost += Math.abs(s.charAt(right) - t.charAt(right));
//      while (currCost > maxCost) {
//        currCost -= Math.abs(s.charAt(left) - t.charAt(left));
//        left++;
//      }
//      answer = Math.max(answer, right - left + 1);
//    }
//    return answer;
//  }
//}
