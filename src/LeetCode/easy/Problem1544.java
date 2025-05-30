package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/make-the-string-great/">1544. Make The String Great</a>
 */
public class Problem1544 {

  public static void main(String[] args) {
    assertEquals("leetcode", makeGood("leEeetcode"));
    assertEquals("", makeGood("abBAcC"));
    assertEquals("s", makeGood("s"));
    assertEquals("kkdsFuqUfSDKK", makeGood("kkdsFuqUfSDKK"));
  }

  /**
   * Approach: Stack <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String makeGood(String s) {
    StringBuilder stack = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (!stack.isEmpty() && Math.abs(stack.charAt(stack.length() - 1) - c) == 32) {
        stack.deleteCharAt(stack.length() - 1);
      } else {
        stack.append(c);
      }
    }
    return stack.toString();
  }

//  /**
//   * Approach: Two Pointers <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static String makeGood(String s) {
//    StringBuilder sb = new StringBuilder(s);
//    int end = 0;
//    for (int curr = 0; curr < sb.length(); curr++) {
//      if (end > 0 && Math.abs(sb.charAt(curr) - sb.charAt(end - 1)) == 32)
//        end--;
//      else {
//        sb.setCharAt(end, sb.charAt(curr));
//        end++;
//      }
//    }
//    return sb.substring(0, end);
//  }
}
