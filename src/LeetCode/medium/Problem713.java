package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
 */
public class Problem713 {

  public static void main(String[] args) {
    assertEquals(8, numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
    assertEquals(0, numSubarrayProductLessThanK(new int[] {1,2,3}, 0));
  }

  /**
   * Approach: Sliding Window <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
      return 0; // Handle edge cases where K is 0 or 1 (no sub-arrays possible)
    }
    int answer = 0;
    int product = 1;
    for (int left = 0, right = 0; right < nums.length; right++) {
      product *= nums[right];
      while (product >= k) {
        product /= nums[left++];
      }
      answer += right - left + 1;
    }
    return answer;
  }
}
