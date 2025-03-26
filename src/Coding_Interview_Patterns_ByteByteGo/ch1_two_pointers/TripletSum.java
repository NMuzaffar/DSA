package Coding_Interview_Patterns_ByteByteGo.ch1_two_pointers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/triplet-sum">Triplet Sum</a>
 */
public class TripletSum {

  public static void main(String[] args) {
    assertIterableEquals(List.of(List.of(-3, 1, 2), List.of(-1, 0, 1)), tripletSum(new int[] {0, -1, 2, -3, 1}));
  }

//  /**
//   * Approach: Two Pointers (Inward traversing) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static List<List<Integer>> tripletSum(int[] nums) {
//    return null;
//  }

  /**
   * Approach: Brute Force <br>
   * Time Complexity: O() <br>
   * Space Complexity: O() <br>
   */
  public static List<List<Integer>> tripletSum(int[] nums) {
    Set<List<Integer>> triplets = new HashSet<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
            triplets.add(triplet);
          }
        }
      }
    }

    return new ArrayList<>(triplets);
  }
}
