package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/intersection-of-multiple-arrays/">2248. Intersection of Multiple Arrays</a>
 */
public class Problem2248 {

  public static void main(String[] args) {
    assertArrayEquals(List.of(3,4).toArray(), intersection(new int[][] {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}}).toArray());
    assertArrayEquals(Collections.emptyList().toArray(), intersection(new int[][] {{1, 2, 3}, {4, 5, 6}}).toArray());
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(m * (n + log(m)) <br>
   * Space Complexity: O(n * m) <br>
   */
  public static List<Integer> intersection(int[][] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int[] arr : nums) { // O(n * m)
      for (int num : arr) {
        counts.put(num, counts.getOrDefault(num, 0) + 1);
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int num : counts.keySet()) {
      if (counts.get(num) == nums.length) {
        result.add(num);
      }
    }
    Collections.sort(result); // O(m * log(m))
    return result;
  }
}
