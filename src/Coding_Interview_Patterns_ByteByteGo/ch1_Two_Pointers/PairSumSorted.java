package Coding_Interview_Patterns_ByteByteGo.ch1_Two_Pointers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/pair-sum-sorted">Pair Sum - Sorted</a>
 */
public class PairSumSorted {

  public static void main(String[] args) {
    assertEquals(List.of(2, 3), pairSumSorted(List.of(-5, -2, 3, 4, 6), 7));
    assertValidOutputs(
        Set.of(Set.of(0, 1), Set.of(0, 2), Set.of(1, 2)),
        pairSumSorted(List.of(1, 1, 1), 2));
    assertEquals(List.of(), pairSumSorted(List.of(), 0));
    assertEquals(List.of(), pairSumSorted(List.of(1), 1));
    assertEquals(List.of(0, 1), pairSumSorted(List.of(2, 3), 5));
    assertEquals(List.of(), pairSumSorted(List.of(2, 4), 5));
    assertValidOutputs(
        Set.of(Set.of(0, 2), Set.of(1, 2)),
        pairSumSorted(List.of(2, 2, 3), 5));
    assertEquals(List.of(0, 2), pairSumSorted(List.of(-1, 2, 3), 2));
    assertEquals(List.of(0, 1), pairSumSorted(List.of(-3, -2, -1), -5));
  }

  private static void assertValidOutputs(Set<Set<Integer>> validResults, List<Integer> result) {
    assertTrue(validResults.contains(new HashSet<>(result)), "Result: " + result + " is not a valid combination");
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static List<Integer> pairSumSorted(List<Integer> nums, int target) {
    int left = 0;
    int right = nums.size() - 1;
    while (left < right) {
      int sum = nums.get(left) + nums.get(right);
      if (sum < target) {
        left++;
      } else if (sum > target) {
        right--;
      } else {
        return List.of(left, right);
      }
    }
    return Collections.emptyList();
  }

//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static List<Integer> pairSumSorted(List<Integer> nums, int target) {
//    int n = nums.size();
//    for (int i = 0; i < n; i++) {
//      for (int j = i + 1; j < n; j++) {
//        if (nums.get(i) + nums.get(j) == target) {
//          return List.of(i, j);
//        }
//      }
//    }
//    return Collections.emptyList();
//  }
}
