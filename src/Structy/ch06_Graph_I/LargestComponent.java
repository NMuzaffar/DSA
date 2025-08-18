package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/largest-component">Largest Component</a>
 */
public class LargestComponent {

  public static void main(String[] args) {
    assertEquals(4, largestComponent(Map.of(
        0, List.of(8, 1, 5),
        1, List.of(0),
        5, List.of(0, 8),
        8, List.of(0, 5),
        2, List.of(3, 4),
        3, List.of(2, 4),
        4, List.of(3, 2)
    )));

    assertEquals(6, largestComponent(Map.of(
        1, List.of(2),
        2, List.of(1,8),
        6, List.of(7),
        9, List.of(8),
        7, List.of(6, 8),
        8, List.of(9, 7, 2)
    )));

    assertEquals(5, largestComponent(Map.of(
        3, List.of(),
        4, List.of(6),
        6, List.of(4, 5, 7, 8),
        8, List.of(6),
        7, List.of(6),
        5, List.of(6),
        1, List.of(2),
        2, List.of(1)
    )));

    assertEquals(0, largestComponent(Map.of()));

    assertEquals(3, largestComponent(Map.of(
        0, List.of(4,7),
        1, List.of(),
        2, List.of(),
        3, List.of(6),
        4, List.of(0),
        6, List.of(3),
        7, List.of(0),
        8, List.of()
    )));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(e) <br>
   * Space Complexity: O(n) <br>
   */
  public static int largestComponent(Map<Integer, List<Integer>> graph) {
    int largest = 0;
    Set<Integer> visited = new HashSet<>();
    for (int node : graph.keySet()) {
      if (!visited.contains(node)) {
        visited.add(node);
        largest = Math.max(largest, traverseSizeDfs(node, graph, visited));
      }
    }
    return largest;
  }

  private static int traverseSizeDfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
    int size = 1;
    for (int neighbor : graph.get(node)) {
      if (!visited.contains(neighbor)) {
        visited.add(neighbor);
        size += traverseSizeDfs(neighbor, graph, visited);
      }
    }
    return size;
  }
}
