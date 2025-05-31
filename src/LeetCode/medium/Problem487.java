//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">487. Max Consecutive Ones II</a>
// */
//public class Problem487 {
//
//  public static void main(String[] args) {
//    assertEquals(4, findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
//    assertEquals(4, findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
//  }
//
//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O() <br>
//   */
//  public static int findMaxConsecutiveOnes(int[] nums) {
//      int answer = 0;
//      for (int left = 0; left < nums.length; left++) {
//          int zeroesCount = 0;
//
//          for (int right = left; right < nums.length; right++) {
//              if (nums[right] == 0) {
//                  zeroesCount++;
//              }
//          }
//      }
//      return answer;
//  }
//}
