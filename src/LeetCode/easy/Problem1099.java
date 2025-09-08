//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//
///**
// * <a href="https://leetcode.com/problems/two-sum-less-than-k/">1099. Two Sum Less Than K</a>
// */
//public class Problem1099 {
//
//  public static void main(String[] args) {
//    assertEquals(58, twoSumLessThanK(new int[] {34, 23, 1, 24, 75, 33, 54, 8}, 60));
//    assertEquals(-1, twoSumLessThanK(new int[] {10, 20, 30}, 15));
//  }
//
//  /**
//   * Approach: Two Pointers <br>
//   * Time Complexity: O(n * log(n)) <br>
//   * Space Complexity: O(log(n)) <-> Quicksort Algorithm in Java <br>
//   */
//  public static int twoSumLessThanK(int[] nums, int k) {
//    Arrays.sort(nums);
//    int answer = -1;
//    int left = 0;
//    int right = nums.length - 1;
//    while (left < right) {
//      int sum = nums[left] + nums[right];
//      if (sum < k) {
//        answer = Math.max(answer, sum);
//        left++;
//      } else {
//        right--;
//      }
//    }
//    return answer;
//  }
//
////  /**
////   * Approach: Brute Force <br>
////   * Time Complexity: O(n^2) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int twoSumLessThanK(int[] nums, int k) {
////    int answer = -1;
////    for (int i = 0; i < nums.length; i++) {
////      for (int j = i + 1; j < nums.length; j++) {
////        int sum = nums[i] + nums[j];
////        if (sum < k) {
////          answer = Math.max(answer, sum);
////        }
////      }
////    }
////    return answer;
////  }
//}
