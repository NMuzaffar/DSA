//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">1004. Max Consecutive Ones III</a>
// */
//public class Problem1004 {
//
//  public static void main(String[] args) {
//    assertEquals(6, longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//    assertEquals(10, longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
//  }
//
//  /**
//   * Approach: Sliding Window (keep Maximum Window) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int longestOnes(int[] nums, int k) {
//    int left = 0;
//    int right;
//    for (right = 0; right < nums.length; right++) {
//      // If we included a zero in the window we reduce the value of k.
//      // Since k is the maximum zeros allowed in a window.
//      if (nums[right] == 0) {
//        k--;
//      }
//      // A negative k denotes we have consumed all allowed flips and window has
//      // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
//      if (k < 0) {
//        // If the left element to be thrown out is zero we increase k.
//        k += 1 - nums[left];
//        left++;
//      }
//    }
//    return right - left;
//  }
//
////  /**
////   * Approach: Sliding Window <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int longestOnes(int[] nums, int k) {
////    int answer = 0;
////    int flips = 0;
////    int left = 0;
////
////    for (int right = 0; right < nums.length; right++) {
////      if (nums[right] == 0) {
////        flips++;
////      }
////      while (flips > k) {
////        if (nums[left] == 0) {
////          flips--;
////        }
////        left++;
////      }
////      answer = Math.max(answer, right - left + 1);
////    }
////
////    return answer;
////  }
//}
