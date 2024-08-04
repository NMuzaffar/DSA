package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 */
public class Problem977 {

  public static void main(String[] args) {
    assertArrayEquals(new int[]{0,1,9,16,100}, sortedSquares(new int[]{-4,-1,0,3,10}));
    assertArrayEquals(new int[]{4,9,9,49,121}, sortedSquares(new int[]{-7,-3,2,3,11}));
  }

  /**
   * Approach: Sort
   * Time complexity: O(n log(n))
   * Space complexity: O(log n) -> Quicksort Algorithm in Java
   */
  public static int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = (int) Math.pow(nums[i], 2);
    }
    Arrays.sort(ans);
    return ans;
  }
}
