package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
 */
public class Problem977 {

  public static void main(String[] args) {
    assertArrayEquals(new int[]{0,1,9,16,100}, sortedSquares(new int[]{-4,-1,0,3,10}));
    assertArrayEquals(new int[]{4,9,9,49,121}, sortedSquares(new int[]{-7,-3,2,3,11}));
  }

  /**
   * Approach: Two Pointers <br>
   * Time complexity: O(n) <br>
   * Space complexity: O(n) <br>
   */
  public static int[] sortedSquares(int[] nums) {
   int n = nums.length;
   int[] result = new int[n];
   int left = 0;
   int right = n - 1;

   for (int i = n - 1; i >= 0; i--) {
     final int square;
     if (Math.abs(nums[left]) < Math.abs(nums[right])) {
       square = nums[right--];
     } else {
       square = nums[left++];
     }
     result[i] = square * square;
   }
   return result;
  }

//  /**
//   * Approach: Sort <br>
//   * Time complexity: O(n log(n)) <br>
//   * Space complexity: O(log n) -> Quicksort Algorithm in Java <br>
//   */
//  public static int[] sortedSquares(int[] nums) {
//    int n = nums.length;
//    int[] result = new int[n];
//    for (int i = 0; i < n; i++) {
//      result[i] = (int) Math.pow(nums[i], 2);
//    }
//    Arrays.sort(result);
//    return result;
//  }
}
