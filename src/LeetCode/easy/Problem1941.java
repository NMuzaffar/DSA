package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/">1941. Check if All Characters Have Equal Number of Occurrences</a>
 */
public class Problem1941 {

  public static void main(String[] args) {
    assertTrue(areOccurrencesEqual("abacbc"));
    assertFalse(areOccurrencesEqual("aaabb"));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n) <br>
   * Space Complexity:  O(1) (OR O(k), k <-> the number of characters that could be in the input) <br>
   */
  public static boolean areOccurrencesEqual(String s) {
    Map<Character, Integer> counts = new HashMap<>();
    for (char c: s.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }
    Set<Integer> frequencies = new HashSet<>(counts.values());
    return frequencies.size() == 1;
  }
}
