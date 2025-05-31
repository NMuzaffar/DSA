//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/find-pivot-index/">724. Find Pivot Index</a>
// */
//public class Problem724 {
//
//  public static void main(String[] args) {
//    assertEquals(3, pivotIndex(new int[] {1,7,3,6,5,6}));
//    assertEquals(-1, pivotIndex(new int[] {1,2,3}));
//    assertEquals(0, pivotIndex(new int[] {2,1,-1}));
//  }
//
//  /**
//   * Approach: Prefix Sum (Space Optimal) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int pivotIndex(int[] nums) {
//    int totalSum = 0;
//    for (int num : nums) {
//      totalSum += num;
//    }
//
//    int leftSum = 0;
//    for (int i = 0; i < nums.length; i++) {
//      if (leftSum == totalSum - leftSum - nums[i]) {
//        return i;
//      }
//      leftSum += nums[i];
//    }
//    return -1;
//  }
//
////  /**
////   * Approach: Prefix Sum <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static int pivotIndex(int[] nums) {
////    int n = nums.length;
////
////    int[] prefix = new int[n];
////    prefix[0] = nums[0];
////    for (int i = 1; i < n; i++) {
////      prefix[i] = prefix[i - 1] + nums[i];
////    }
////
////    for (int i = 0; i < n; i++) {
////      int leftSum = prefix[i] - nums[i];
////      int rightSum = prefix[n - 1] - prefix[i];
////      if (leftSum == rightSum) {
////        return i;
////      }
////    }
////    return -1;
////  }
//}
