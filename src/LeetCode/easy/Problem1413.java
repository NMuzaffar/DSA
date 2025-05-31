//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/">1413. Minimum Value to Get Positive Step by Step Sum</a>
// */
//public class Problem1413 {
//
//  public static void main(String[] args) {
//    assertEquals(5, minStartValue(new int[] {-3,2,-3,4,2}));
//    assertEquals(1, minStartValue(new int[] {1,2}));
//    assertEquals(5, minStartValue(new int[] {1,-2,-3}));
//  }
//
//  /**
//   * Approach: Prefix total <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int minStartValue(int[] nums) {
//    int minVal = 0; // minimum step-by-step total
//    int total = 0; // current step-by-step total
//    for (int num : nums) {
//      total += num;
//      minVal = Math.min(minVal, total);
//    }
//    return 1 - minVal; // (minVal + startValue = 1) <=> (startValue = 1 - minVal)
//  }
//
////  /**
////   * Approach: Brute Force <br>
////   * Time Complexity: O(n^2 * m) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int minStartValue(int[] nums) {
////    int startValue = 1;
////    while (true) {
////      int total = startValue;
////      boolean isValid = true;
////      for (int num : nums) {
////        total += num;
////        if (total < 1) {
////          isValid = false;
////          break;
////        }
////      }
////      if (isValid) {
////        return startValue;
////      } else {
////        startValue++;
////      }
////    }
////  }
//}
