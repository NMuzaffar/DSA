package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://structy.net/problems/has-path">Has Path</a>
 */
public class HasPath {

  public static void main(String[] args) {
    final Map<String, List<String>> graph0 = Map.of(
        "f", List.of("g", "i"),
        "g", List.of("h"),
        "h", List.of(),
        "i", List.of("g", "k"),
        "j", List.of("i"),
        "k", List.of()
    );
    assertTrue(hasPath(graph0, "f", "k"));
    assertFalse(hasPath(graph0, "f", "j"));
    assertTrue(hasPath(graph0, "i", "h"));

    final Map<String, List<String>> graph1 = Map.of(
        "v", List.of("x", "w"),
        "w", List.of(),
        "x", List.of(),
        "y", List.of("z"),
        "z", List.of()
    );
    assertTrue(hasPath(graph1, "v", "w"));
    assertFalse(hasPath(graph1, "v", "z"));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(e) <-> e = # of edges <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean hasPath(Map<String, List<String>> graph, String src, String dst) {
    if (src.equals(dst)) {
      return true;
    }
    for (String neighbor : graph.get(src)) {
      if (hasPath(graph, neighbor, dst)) {
        return true;
      }
    }
    return false;
  }

//  /**
//   * Approach: Graph BFS <br>
//   * Time Complexity: O(e) <-> e = # of edges <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean hasPath(Map<String, List<String>> graph, String src, String dst) {
//    Queue<String> queue = new ArrayDeque<>();
//    queue.add(src);
//    while (!queue.isEmpty()) {
//      String node = queue.remove();
//      if (node.equals(dst)) {
//        return true;
//      }
//      for (String neighbor : graph.get(node)) {
//        queue.add(neighbor);
//      }
//    }
//    return false;
//  }
}
