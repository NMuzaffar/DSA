package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">1480. Running Sum of 1d Array</a>
 */
public class Problem1480 {

  public static void main(String[] args) {
    assertArrayEquals(new int[] {1, 3, 6, 10}, runningSum(new int[] {1, 2, 3, 4}));
    assertArrayEquals(new int[] {1, 2, 3, 4, 5}, runningSum(new int[] {1, 1, 1, 1, 1}));
    assertArrayEquals(new int[] {3, 4, 6, 16, 17}, runningSum(new int[] {3, 1, 2, 10, 1}));
  }

  /**
   * Approach: Prefix Sum (Input Array for Output) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int[] runningSum(int[] nums) {
    for(int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }
    return nums;
  }

//  /**
//   * Approach: Prefix Sum <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] runningSum(int[] nums) {
//    int[] answer = new int[nums.length];
//    answer[0] = nums[0];
//    for (int i = 1; i < nums.length; i++) {
//      answer[i] = answer[i - 1] + nums[i];
//    }
//    return answer;
//  }
}
