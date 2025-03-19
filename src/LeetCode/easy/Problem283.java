package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a>
 */
public class Problem283 {

  public static void main(String[] args) {
    int[] nums1 = new int[] {0,1,0,3,12};
    moveZeroes(nums1);
    assertArrayEquals(new int[] {1,3,12,0,0}, nums1);

    int[] nums2 = new int[] {0};
    moveZeroes(nums2);
    assertArrayEquals(new int[] {0}, nums2);

    int[] nums3 = new int[] {1,0};
    moveZeroes(nums3);
    assertArrayEquals(new int[] {1,0}, nums3);
  }

  /**
   * Approach: Two Pointers (Optimal) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static void moveZeroes(int[] nums) {
    for (int lastNonZeroIndex = 0, i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[lastNonZeroIndex];
        nums[lastNonZeroIndex++] = temp;
      }
    }
  }

//  /**
//   * Approach: Two Pointers (Space Optimal, Operation Sub-Optimal) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static void moveZeroes(int[] nums) {
//    int n = nums.length;
//
//    int lastNonZeroIndex = 0;
//    for (int i = 0; i < n; i++) {
//      if (nums[i] != 0) {
//        nums[lastNonZeroIndex++] = nums[i];
//      }
//    }
//
//    for (; lastNonZeroIndex < n; lastNonZeroIndex++) {
//      nums[lastNonZeroIndex] = 0;
//    }
//  }
//
//  /**
//   * Approach: Two Pointers (Space Sub-Optimal) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static void moveZeroes(int[] nums) {
//    int n = nums.length;
//
//    int lastNonZeroIndex = 0;
//    int[] tempAnswer = new int[n];
//    for (int num : nums) {
//      if (num != 0) {
//        tempAnswer[lastNonZeroIndex++] = num;
//      }
//    }
//
//    for (; lastNonZeroIndex < n; lastNonZeroIndex++) {
//      tempAnswer[lastNonZeroIndex] = 0;
//    }
//
//    System.arraycopy(tempAnswer, 0, nums, 0, n);
//  }
}
