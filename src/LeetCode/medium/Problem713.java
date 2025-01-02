package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
 */
public class Problem713 {

  public static void main(String[] args) {
    assertEquals(8, numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    assertEquals(0, numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
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

    int result = 0;
    int left = 0;
    int curr = 1;

    for (int right = 0; right < nums.length; right++) {
      curr *= nums[right];
      while (curr >= k) {
        curr /= nums[left];
        left++;
      }
      result += right - left + 1;
    }

    return result;
  }
}
