//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//
///**
// * <a href="https://leetcode.com/problems/k-radius-subarray-averages/">2090. K Radius Subarray Averages</a>
// */
//public class Problem2290 {
//
//  public static void main(String[] args) {
//    assertArrayEquals(new int[] {-1,-1,-1,5,4,4,-1,-1,-1}, getAverages(new int[] {7,4,3,9,1,8,5,2,6}, 3));
//    assertArrayEquals(new int[] {100000}, getAverages(new int[] {100000}, 0));
//    assertArrayEquals(new int[] {-1}, getAverages(new int[] {8}, 100000));
//  }
//
//  /**
//   * Approach: Sliding Window <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] getAverages(int[] nums, int k) {
//    if (k == 0) {
//      return nums;
//    }
//
//    int n = nums.length;
//    int windowSize = 2 * k + 1;
//
//    int[] answer = new int[n];
//    Arrays.fill(answer, -1);
//
//    // Any index will not have 'k' elements in its left and right.
//    if (windowSize > n) {
//      return answer;
//    }
//
//    long windowSum = 0;
//    for (int i = 0; i < windowSize; i++) {
//      windowSum += nums[i];
//    }
//    answer[k] = (int) (windowSum / windowSize);
//
//    for (int i = windowSize; i < n; i++) {
//      windowSum += nums[i] - nums[i - windowSize];
//      answer[i - k] = (int) (windowSum / windowSize);
//    }
//
//    return answer;
//  }
//
////  /**
////   * Approach: Prefix Sum <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static int[] getAverages(int[] nums, int k) {
////    if (k == 0) {
////      return nums;
////    }
////
////    int n = nums.length;
////    int windowSize = 2 * k + 1;
////
////    int[] answer = new int[n];
////    Arrays.fill(answer, -1);
////
////    // Any index will not have 'k' elements in its left and right.
////    if (windowSize > n) {
////      return answer;
////    }
////
////    long[] prefix = new long[n];
////    prefix[0] = nums[0];
////    for (int i = 1; i < n; i++) {
////      prefix[i] = prefix[i - 1] + nums[i];
////    }
////
////    for (int i = k; i < (n - k); i++) {
////      int leftBound = i - k;
////      int rightBound = i + k;
////      long subarraySum = prefix[rightBound] - prefix[leftBound] + nums[leftBound];
////      answer[i] = (int) (subarraySum / windowSize);
////    }
////
////    return answer;
////  }
//}
