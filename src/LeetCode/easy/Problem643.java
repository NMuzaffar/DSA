//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/maximum-average-subarray-i/">643. Maximum Average Subarray I</a>
// */
//public class Problem643 {
//
//  public static void main(String[] args) {
//    assertEquals(12.75d, findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4));
//    assertEquals(5.0d, findMaxAverage(new int[] {5}, 1));
//  }
//
//  /**
//   * Approach: Sliding Window <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static double findMaxAverage(int[] nums, int k) {
//    int sum = 0;
//    for (int i = 0; i < k; i++) {
//      sum += nums[i];
//    }
//
//    int result = sum;
//    for (int i = k; i < nums.length; i++) {
//      sum += nums[i] - nums[i - k];
//      result = Math.max(result, sum);
//    }
//
//    return (double) result / k;
//  }
//
////  /**
////   * Approach: Cumulative Sum <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static double findMaxAverage(int[] nums, int k) {
////    int n = nums.length;
////
////    int[] sum = new int[n];
////    sum[0] = nums[0];
////    for (int i = 1; i < n; i++) {
////      sum[i] = sum[i - 1] + nums[i];
////    }
////
////    int result = sum[k - 1];
////    for (int i = k; i < n; i++) {
////      result = Math.max(result, sum[i] - sum[i - k]);
////    }
////    return (double) result / k;
////  }
//}
