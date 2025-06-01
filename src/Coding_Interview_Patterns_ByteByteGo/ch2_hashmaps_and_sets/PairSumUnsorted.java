package Coding_Interview_Patterns_ByteByteGo.ch2_hashmaps_and_sets;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/hash-maps-and-sets/pair-sum-unsorted">Pair Sum - Unsorted</a>
 */
public class PairSumUnsorted {

  public static void main(String[] args) {
    assertArrayEquals(new int[] {0, 2}, pairSumSorted(new int[] {-1, 3, 4, 2}, 3));
  }

  /**
   * Approach: Hash Map (One Pass) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int[] pairSumSorted(int[] nums, int target) {
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
//   * Approach: Hash Map (Two Pass) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] pairSumSorted(int[] nums, int target) {
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
}
