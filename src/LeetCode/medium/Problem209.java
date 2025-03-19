package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">209. Minimum Size Subarray Sum</a>
 */
public class Problem209 {

  public static void main(String[] args) {
    assertEquals(2, minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    assertEquals(1, minSubArrayLen(4, new int[] {1,4,4}));
    assertEquals(0, minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
  }

  /**
   * Approach: Sliding Window <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int minSubArrayLen(int target, int[] nums) {
    int answer = Integer.MAX_VALUE;

    int currWindowSum = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      currWindowSum += nums[right];
      while (currWindowSum >= target) {
        answer = Math.min(answer, right - left + 1);
        currWindowSum -= nums[left++];
      }
    }

    return (answer == Integer.MAX_VALUE) ? 0 : answer;
  }
}
