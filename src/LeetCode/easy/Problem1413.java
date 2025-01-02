//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">1480. Running Sum of 1d Array</a>
// */
//public class Problem1413 {
//
//  public static void main(String[] args) {
//    assertArrayEquals(new int[]{1,3,6,10}, runningSum(new int[]{1,2,3,4}));
//    assertArrayEquals(new int[]{1,2,3,4,5}, runningSum(new int[]{1,1,1,1,1}));
//    assertArrayEquals(new int[]{3,4,6,16,17}, runningSum(new int[]{3,1,2,10,1}));
//  }
//
//  /**
//   * Approach: Prefix Sum <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int[] runningSum(int[] nums) {
//
//  }
//
////  /**
////   Approach: Prefix Sum (Using Input Array for Output)
////   Time Complexity: O(n)
////   Space Complexity: O(1)
////   */
////  public int[] runningSum(int[] nums) {
////    for (int i = 1; i < nums.length; i++) {
////      nums[i] += nums[i - 1];
////    }
////    return nums;
////  }
////
////  // /**
////  //     Approach: Prefix Sum (Using Separate Space)
////  //     Time Complexity: O(n)
////  //     Space Complexity: O(n)
////  //  */
////  // public int[] runningSum(int[] nums) {
////  //     int[] prefix = new int[nums.length];
////  //     prefix[0] = nums[0];
////  //     for (int i = 1; i < nums.length; i++) {
////  //         prefix[i] = prefix[i - 1] + nums[i];
////  //     }
////  //     return prefix;
////  // }
//}
