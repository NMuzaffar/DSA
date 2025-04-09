package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 */
public class Problem1 {

  public static void main(String[] args) {
    assertArrayEquals(new int[] {0,1}, twoSum(new int[] {2,7,11,15}, 9));
    assertArrayEquals(new int[] {1,2}, twoSum(new int[] {3,2,4}, 6));
    assertArrayEquals(new int[] {0,1}, twoSum(new int[] {3,3}, 6));
  }

  /**
   * Approach: One-pass Hash Table <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numsMap.containsKey(complement)) {
        return new int[] {numsMap.get(complement), i};
      }
      numsMap.put(nums[i], i);
    }
    return new int[] {};
  }

//  /**
//   * Approach: Two-pass Hash Table <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] twoSum(int[] nums, int target) {
//    Map<Integer, Integer> numsMap = new HashMap<>();
//    for (int i = 0; i < nums.length; i++) {
//      numsMap.put(nums[i], i);
//    }
//    for (int i = 0; i < nums.length; i++) {
//      int complement = target - nums[i];
//      if (numsMap.containsKey(complement) && numsMap.get(complement) != i) {
//        return new int[] {i, numsMap.get(complement)};
//      }
//    }
//    return new int[] {};
//  }
//
//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int[] twoSum(int[] nums, int target) {
//    for (int i = 0; i < nums.length; i++) {
//      for (int j = i + 1; j < nums.length; j++) {
//        if (nums[i] + nums[j] == target) {
//          return new int[] {i, j};
//        }
//      }
//    }
//    return new int[] {};
//  }
}
