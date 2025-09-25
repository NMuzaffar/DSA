package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

/**
 * <a href="https://structy.net/problems/undirected-path">Undirected Path</a>
 */
public class UndirectedPath {

  public static void main(String[] args) {
    final List<List<String>> edges0 = List.of(
        List.of("i", "j"),
        List.of("k", "i"),
        List.of("m", "k"),
        List.of("k", "l"),
        List.of("o", "n")
    );
    assertTrue(undirectedPath(edges0, "j", "m"));
    assertTrue(undirectedPath(edges0, "m", "j"));
    assertTrue(undirectedPath(edges0, "l", "j"));
    assertFalse(undirectedPath(edges0, "k", "o"));
    assertFalse(undirectedPath(edges0, "i", "o"));

    final List<List<String>> edges1 = List.of(
        List.of("b", "a"),
        List.of("c", "a"),
        List.of("b", "c"),
        List.of("q", "r"),
        List.of("q", "s"),
        List.of("q", "u"),
        List.of("q", "t")
    );
    assertTrue(undirectedPath(edges1, "a", "b"));
    assertTrue(undirectedPath(edges1, "a", "c"));
    assertTrue(undirectedPath(edges1, "r", "t"));
    assertFalse(undirectedPath(edges1, "r", "b"));

    final List<List<String>> edges2 = List.of(
        List.of("s", "r"),
        List.of("t", "q"),
        List.of("q", "r")
    );
    assertTrue(undirectedPath(edges2, "r", "t"));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(e) <-> e = # of edges <br>
   * Space Complexity: O(e) <br>
   */
  public static boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {
    Map<String, List<String>> graph = buildGraph(edges);
    Set<String> visited = new HashSet<>();
    visited.add(nodeA);
    return dfs(graph, nodeA, nodeB, visited);
  }

  private static boolean dfs(Map<String, List<String>> graph, String nodeA, String nodeB, Set<String> visited) {
    if (nodeA.equals(nodeB)) {
      return true;
    }
    for (String neighbor : graph.get(nodeA)) {
      if (!visited.contains(neighbor)) {
        visited.add(neighbor);
        if (dfs(graph, neighbor, nodeB, visited)) {
          return true;
        }
      }
    }
    return false;
  }

//  /**
//   * Approach: Graph BFS <br>
//   * Time Complexity: O(e) <-> e = # of edges <br>
//   * Space Complexity: O(e) <br>
//   */
//  public static boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {
//    Map<String, List<String>> graph = buildGraph(edges);
//    Queue<String> queue = new ArrayDeque<>();
//    Set<String> visited = new HashSet<>();
//    queue.add(nodeA);
//    visited.add(nodeA);
//    while (!queue.isEmpty()) {
//      String node = queue.remove();
//      if (node.equals(nodeB)) {
//        return true;
//      }
//      for (String neighbor : graph.get(node)) {
//        if (!visited.contains(neighbor)) {
//          visited.add(neighbor);
//          queue.add(neighbor);
//        }
//      }
//    }
//    return false;
//  }

  private static Map<String, List<String>> buildGraph(List<List<String>> edges) {
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> edge : edges) {
      String x = edge.get(0);
      String y = edge.get(1);
      graph.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
      graph.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
    }
    return graph;
  }
}
