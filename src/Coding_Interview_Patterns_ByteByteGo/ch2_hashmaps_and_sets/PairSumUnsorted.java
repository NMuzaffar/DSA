package Coding_Interview_Patterns_ByteByteGo.ch2_hashmaps_and_sets;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/hash-maps-and-sets/pair-sum-unsorted">Pair Sum - Unsorted</a>
 */
public class PairSumUnsorted {

  public static void main(String[] args) {
    assertArrayEquals(new int[]{0, 2}, pairSumSorted(new int[]{-1, 3, 4, 2}, 3));
  }

  /**
   * Approach: Two-pass Hash Table <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int[] pairSumSorted(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (!numsMap.containsKey(complement)) {
        numsMap.put(nums[i], i);
      } else {
        int x = numsMap.get(complement);
        int y = i;
        return new int[]{x, y};
      }
    }
    return new int[]{};
  }

//  /**
//   * Approach: One-pass Hash Table <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] pairSumSorted(int[] nums, int target) {
//    Map<Integer, Integer> numsMap = new HashMap<>();
//    for (int i = 0; i < nums.length; i++) {
//      numsMap.put(nums[i], i);
//    }
//
//    for (int num : nums) {
//      int complement = target - num;
//      if (numsMap.containsKey(complement)) {
//        int x = numsMap.get(num);
//        int y = numsMap.get(complement);
//        return new int[]{x, y};
//      }
//    }
//
//    return new int[]{};
//  }
}
