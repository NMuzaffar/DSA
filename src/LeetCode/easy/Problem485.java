//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/max-consecutive-ones/">485. Max Consecutive Ones</a>
// */
//public class Problem485 {
//
//  public static void main(String[] args) {
//    assertEquals(3, findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
//    assertEquals(2, findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0, 1}));
//  }
//
//  /**
//   * Approach: One Pass <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int findMaxConsecutiveOnes(int[] nums) {
//    int maxCount = 0;
//    int count = 0;
//    for (int i = 0; i < nums.length; i++) {
//      if (nums[i] == 1) {
//        count++;
//      } else {
//        maxCount = Math.max(maxCount, count);
//        count = 0;
//      }
//    }
//    return Math.max(maxCount, count);
//  }
//}
