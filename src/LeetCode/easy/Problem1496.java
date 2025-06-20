package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/path-crossing/">1496. Path Crossing</a>
 */
public class Problem1496 {

  public static void main(String[] args) {
    assertFalse(isPathCrossing("NES"));
    assertTrue(isPathCrossing("NESWW"));
  }

  /**
   * Approach: Hash Set <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean isPathCrossing(String path) {
    Map<Character, Map.Entry<Integer, Integer>> directions = Map.of(
        'N', Map.entry(0, 1),
        'S', Map.entry(0, -1),
        'E', Map.entry(1, 0),
        'W', Map.entry(-1, 0)
    );
    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
    visited.add(Map.entry(0, 0));
    int x = 0;
    int y = 0;
    for (char c : path.toCharArray()) {
      Map.Entry<Integer, Integer> movement = directions.get(c);
      x += movement.getKey();
      y += movement.getValue();
      if (!visited.add(Map.entry(x, y))) {
        return true;
      }
    }
    return false;
  }
}
