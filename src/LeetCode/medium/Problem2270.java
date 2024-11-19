package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-split-array/">2270. Number of Ways to Split Array</a>
 */
public class Problem2270 {

  public static void main(String[] args) {
    assertEquals(2, waysToSplitArray(new int[]{10,4,-8,7}));
    assertEquals(2, waysToSplitArray(new int[]{2,3,1,0}));
  }

  /**
   * Approach: Prefix Sum (with the improved space complexity) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int waysToSplitArray(int[] nums) {
    int validSplits = 0;
    long total = 0L;
    long leftSection = 0L;

    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
    }

    for (int i = 0; i < nums.length - 1; i++) {
      leftSection += nums[i];
      long rightSection = total - leftSection;
      if (leftSection >= rightSection) {
        validSplits++;
      }
    }
    return validSplits;
  }

//  /**
//   * Approach: Prefix Sum <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int waysToSplitArray(int[] nums) {
//    int n = nums.length;
//
//    long[] prefix = new long[n];
//    prefix[0] = nums[0];
//    for (int i = 1; i < n; i++) {
//      prefix[i] = prefix[i - 1] + nums[i];
//    }
//
//    int validSplits = 0;
//    for (int i = 0; i < n - 1; i++) {
//      long leftSection = prefix[i];
//      long rightSection = prefix[n - 1] - leftSection;
//      if (leftSection >= rightSection) {
//        validSplits++;
//      }
//    }
//    return validSplits;
//  }

//  /**
//   * Approach: Brute Force -> Time Limit Exceeded <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int waysToSplitArray(int[] nums) {
//    int validSplits = 0;
//    for (int i = 0; i < nums.length - 1; i++) {
//      long leftSection = 0L;
//      for (int j = 0; j <= i; j++) {
//        leftSection += nums[j];
//      }
//
//      long rightSection = 0L;
//      for (int j = i + 1; j < nums.length; j++) {
//        rightSection += nums[j];
//      }
//
//      if ((leftSection >= rightSection)) {
//        validSplits++;
//      }
//    }
//    return validSplits;
//  }
}
