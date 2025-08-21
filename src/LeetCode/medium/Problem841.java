package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/keys-and-rooms/">841. Keys and Rooms</a>
 */
public class Problem841 {

  public static void main(String[] args) {
    assertTrue(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
    assertFalse(canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0))));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(e) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited = new HashSet<>();
    visited.add(0);
    dfs(0, rooms, visited);
    return visited.size() == rooms.size();
  }

  private static void dfs(int node, List<List<Integer>> rooms, Set<Integer> visited) {
    for (int neighbor : rooms.get(node)) {
      if (!visited.contains(neighbor)) {
        visited.add(neighbor);
        dfs(neighbor, rooms, visited);
      }
    }
  }
}
