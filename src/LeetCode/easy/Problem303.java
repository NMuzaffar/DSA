package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-immutable/">303. Range Sum Query - Immutable</a>
 */
public class Problem303 {

  public static void main(String[] args) {
    NumArray numArray = new NumArray(new int[] {-2,0,3,-5,2,-1});
    assertEquals(1, numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
    assertEquals(-1, numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
    assertEquals(-3, numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
  }

  /**
   * Your NumArray object will be instantiated and called as such:
   * NumArray obj = new NumArray(nums);
   * int param_1 = obj.sumRange(left,right);
   */

  /**
   * Approach: Prefix Sum <br>
   * Time Complexity: NumArray() -> O(N). sumRange() -> O(1) <br>
   * Space Complexity: O(n) <br>
   */
  static class NumArray {
    private final int[] prefix;

    public NumArray(int[] nums) {
      int n = nums.length;
      prefix = new int[n + 1];
      for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
      }
    }

    public int sumRange(int left, int right) {
      return prefix[right + 1] - prefix[left];
    }
  }

//  /**
//   * Approach: Brute Force -> Time Limit Exceeded <br>
//   * Time Complexity: NumArray() -> O(N). sumRange() -> O(N) <br>
//   * Space Complexity: O(1) <br>
//   */
//  static class NumArray {
//    private final int[] data;
//
//    public NumArray(int[] nums) {
//     data = nums;
//    }
//
//    public int sumRange(int left, int right) {
//      int sum = 0;
//      for (int i = left; i <= right; i++) {
//        sum += data[i];
//      }
//      return sum;
//    }
//  }
}
