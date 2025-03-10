package CodingInterviewPatterns_ByteByteGo.ch1_two_pointers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/pair-sum-sorted">Pair Sum - Sorted</a>
 */
public class PairSumSorted {

  public static void main(String[] args) {
    assertArrayEquals(new int[] {2, 3}, pairSumSorted(new int[] {-5, -2, 3, 4, 6}, 7));
    assertArrayEquals(new int[] {0, 2}, pairSumSorted(new int[] {1, 1, 1}, 2));
    assertArrayEquals(new int[] {}, pairSumSorted(new int[] {}, 0));
    assertArrayEquals(new int[] {}, pairSumSorted(new int[] {1}, 1));
    assertArrayEquals(new int[] {0, 1}, pairSumSorted(new int[] {2, 3}, 5));
    assertArrayEquals(new int[] {}, pairSumSorted(new int[] {2, 4}, 5));
    assertArrayEquals(new int[] {0, 2}, pairSumSorted(new int[] {2, 2, 3}, 5));
    assertArrayEquals(new int[] {0, 2}, pairSumSorted(new int[] {-1, 2, 3}, 2));
    assertArrayEquals(new int[] {0, 1}, pairSumSorted(new int[] {-3, -2, -1}, -5));
  }

  /**
   * Approach: Two Pointers (Inward traversal) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int[] pairSumSorted(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum < target) {
        left++;
      } else if (sum > target) {
        right--;
      } else {
        return new int[] {left, right};
      }
    }
    return new int[] {};
  }

//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int[] pairSumSorted(int[] nums, int target) {
//    int n = nums.length;
//    for (int i = 0; i < n; i++) {
//      for (int j = i + 1; j < n; j++) {
//        if (nums[i] + nums[j] == target) {
//          return new int[] {i, j};
//        }
//      }
//    }
//    return new int[] {};
//  }
}
