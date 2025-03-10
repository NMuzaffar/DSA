//package CodingInterviewPatterns_ByteByteGo.ch9_prefix_sums;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://bytebytego.com/exercises/coding-patterns/prefix-sums/k-sum-subarrays">K-Sum Subarrays</a>
// */
//public class KSumSubarrays {
//
//  public static void main(String[] args) {
//    assertEquals(3, kSumSubarrays(new int[]{1, 2, -1, 1, 2}, 3));
//  }
//
//  /**
//   * Approach: Sliding Window <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int kSumSubarrays(int[] nums, int k) {
//    int subArraysCount = 0;
//    int left = 0;
//    int currSum = 0;
//    for (int right = 0; right < nums.length; right++) {
//      currSum += nums[right];
//      while () {
//
//      }
//      subArraysCount += right - left + 1;
//    }
//    return subArraysCount;
//  }
//}
