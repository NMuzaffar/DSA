package Structy.ch01_Hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/premium/all-unique">All Unique</a>
 */
public class AllUnique {

  public static void main(String[] args) {
    assertTrue(allUnique(List.of("q", "r", "s", "a")));
    assertFalse(allUnique(List.of("q", "r", "s", "a", "r", "z")));
    assertTrue(allUnique(List.of("red", "blue", "yellow", "green", "orange")));
    assertFalse(allUnique(List.of("cat", "cat", "dog")));
    assertFalse(allUnique(List.of("a", "u", "t", "u", "m", "n")));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean allUnique(List<String> items) {
    Set<String> uniqueItems = new HashSet<>(items);
    return uniqueItems.size() == items.size();
  }
}
