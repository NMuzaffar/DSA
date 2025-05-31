package Coding_Interview_Patterns_ByteByteGo.ch1_two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/triplet-sum">Triplet Sum</a>
 */
public class TripletSum {

  public static void main(String[] args) {
    assertTripletSumEquals(List.of(List.of(-3, 1, 2), List.of(-1, 0, 1)), tripletSum(new int[] {0, -1, 2, -3, 1}));
    assertTripletSumEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), tripletSum(new int[] {-1, 0, 1, 2, -1, -4}));
    assertTripletSumEquals(List.of(List.of(-1, -1, 2)), tripletSum(new int[] {-1, 2, -2, 1, -1, 2}));
    assertTripletSumEquals(List.of(List.of(-4, 1, 3), List.of(-2, 0 ,2)), tripletSum(new int[] {-4, -4, -2, 0, 0, 1, 2, 3}));
    assertTripletSumEquals(List.of(), tripletSum(new int[] {}));
    assertTripletSumEquals(List.of(), tripletSum(new int[] {0}));
    assertTripletSumEquals(List.of(), tripletSum(new int[] {1, -1}));
    assertTripletSumEquals(List.of(List.of(0, 0, 0)), tripletSum(new int[] {0, 0, 0}));
    assertTripletSumEquals(List.of(), tripletSum(new int[] {1, 0, 1}));
    assertTripletSumEquals(List.of(List.of(-1, 0, 1)), tripletSum(new int[] {0, 0, 1, -1, 1, -1}));
  }

  private static void assertTripletSumEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
    assertEquals(normalize(expected), normalize(actual));
  }

  // Helper method to normalize triplets for reliable comparison
  private static List<List<Integer>> normalize(List<List<Integer>> triplets) {
    List<List<Integer>> normalized = new ArrayList<>();
    for (List<Integer> triplet : triplets) {
      List<Integer> sortedTriplet = new ArrayList<>(triplet);
      Collections.sort(sortedTriplet);
      normalized.add(sortedTriplet);
    }
    normalized.sort((a, b) -> {
      for (int i = 0; i < 3; i++) {
        int cmp = Integer.compare(a.get(i), b.get(i));
        if (cmp != 0) return cmp;
      }
      return 0;
    });
    return normalized;
  }

  /**
   * Approach: Two Pointers (Inward Traversal) <br>
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n) without output array (OR O(n^2) with output array) <br>
   */
  public static List<List<Integer>> tripletSum(int[] nums) {
    List<List<Integer>> triplets = new ArrayList<>();
    Arrays.sort(nums); // O(n * log(n))
    for (int i = 0; i < nums.length; i++) {
      // Optimization: triplets consisting of only positive numbers will never sum to 0.
      if (nums[i] > 0) {
        break;
      }
      // To avoid duplicate triplets, skip 'a' if it's the same as the previous number.
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      List<List<Integer>> pairs = pairSumSortedAllPairs(nums, i + 1, -nums[i]);
      for (List<Integer> pair : pairs) {
        triplets.add(List.of(nums[i], pair.get(0), pair.get(1)));
      }
    }
    return triplets;
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  private static List<List<Integer>> pairSumSortedAllPairs(int[] nums, int startIndex, int target) {
    List<List<Integer>> pairs = new ArrayList<>();
    int left = startIndex;
    int right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        pairs.add(List.of(nums[left], nums[right]));
        left++;
        // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the same as the previous number.
        while (left < right && nums[left] == nums[left - 1]) {
          left++;
        }
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return pairs;
  }

//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n^3) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<List<Integer>> tripletSum(int[] nums) {
//    Set<List<Integer>> triplets = new HashSet<>();
//    int n = nums.length;
//    for (int i = 0; i < n; i++) {
//      for (int j = i + 1; j < n; j++) {
//        for (int k = j + 1; k < n; k++) {
//          if (nums[i] + nums[j] + nums[k] == 0) {
//            List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
//            Collections.sort(triplet); // O(1)
//            triplets.add(triplet);
//          }
//        }
//      }
//    }
//    return new ArrayList<>(triplets);
//  }
}
