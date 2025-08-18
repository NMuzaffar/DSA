package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/connected-components-count">Connected Components Count</a>
 */
public class ConnectedComponentsCount {

  public static void main(String[] args) {
    assertEquals(2, connectedComponentsCount(Map.of(
        0, List.of(8, 1, 5),
        1, List.of(0),
        5, List.of(0, 8),
        8, List.of(0, 5),
        2, List.of(3, 4),
        3, List.of(2, 4),
        4, List.of(3, 2)
    )));

    assertEquals(1, connectedComponentsCount(Map.of(
        1, List.of(2),
        2, List.of(1,8),
        6, List.of(7),
        9, List.of(8),
        7, List.of(6, 8),
        8, List.of(9, 7, 2)
    )));

    assertEquals(3, connectedComponentsCount(Map.of(
        3, List.of(),
        4, List.of(6),
        6, List.of(4, 5, 7, 8),
        8, List.of(6),
        7, List.of(6),
        5, List.of(6),
        1, List.of(2),
        2, List.of(1)
    )));

    assertEquals(0 ,connectedComponentsCount(Map.of()));

    assertEquals(5, connectedComponentsCount(Map.of(
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
   * Time Complexity: O(e) <-> e = # of edges <br>
   * Space Complexity: O(n) <br>
   */
  public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
    int count = 0;
    Set<Integer> visited = new HashSet<>();
    for (int node : graph.keySet()) {
      if (traverseComponentDfsRecursive(graph, node, visited)) {
        count++;
      }
    }
    return count;
  }

  private static boolean traverseComponentDfsRecursive(Map<Integer, List<Integer>> graph, Integer startNode, Set<Integer> visited) {
    if (!visited.add(startNode)) {
      return false;
    }
    for (int neighbor : graph.get(startNode)) {
      traverseComponentDfsRecursive(graph, neighbor, visited);
    }
    return true;
  }

//  /**
//   * Approach: Graph DFS (Iterative) <br>
//   * Time Complexity: O(e) <-> e = # of edges <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
//    int count = 0;
//    Set<Integer> visited = new HashSet<>();
//    for (int node : graph.keySet()) {
//      if (!visited.contains(node)) {
//        traverseComponentDfsIterative(graph, node, visited);
//        count++;
//      }
//    }
//    return count;
//  }
//
//  private static void traverseComponentDfsIterative(Map<Integer, List<Integer>> graph, Integer startNode, Set<Integer> visited) {
//    Deque<Integer> stack = new ArrayDeque<>();
//    stack.push(startNode);
//    while (!stack.isEmpty()) {
//      int node = stack.pop();
//      if (!visited.add(node)) {
//        continue;
//      }
//      for (int neighbor : graph.get(node)) {
//        if (!visited.contains(neighbor)) {
//          stack.push(neighbor);
//        }
//      }
//    }
//  }
}
