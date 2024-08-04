package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 */
public class Problem344 {

  public static void main(String[] args) {
    char[] s1 = "hello".toCharArray();
    reverseString(s1);
    assertArrayEquals("olleh".toCharArray(), s1);

    char[] s2 = "Hannah".toCharArray();
    reverseString(s2);
    assertArrayEquals("hannaH".toCharArray(), s2);
  }

  /**
   * Approach: Two Pointers
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      char temp = s[left];
      s[left++] = s[right];
      s[right--] = temp;
    }
  }

//   /**
//    * Approach: Recursion, In-Place
//    * Time Complexity: O(n)
//    * Space Complexity: O(n) -> Recursion Stack
//    */
//   public static void reverseString(char[] s) {
//       helper(s, 0, s.length - 1);
//   }
//
//  private static void helper(char[] s, int left, int right) {
//    if (left >= right) {
//      return;
//    }
//    char temp = s[left];
//    s[left] = s[right];
//    s[right] = temp;
//    helper(s, left + 1, right - 1);
//  }
}
