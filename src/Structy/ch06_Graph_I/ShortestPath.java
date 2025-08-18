package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

/**
 * <a href="https://structy.net/problems/shortest-path">Shortest Path</a>
 */
public class ShortestPath {

  public static void main(String[] args) {
    List<List<String>> edges = List.of(
        List.of("w", "x"),
        List.of("x", "y"),
        List.of("z", "y"),
        List.of("z", "v"),
        List.of("w", "v")
    );
    assertEquals(2, shortestPath(edges, "w", "z"));
    assertEquals(1, shortestPath(edges, "y", "x"));

    edges = List.of(
        List.of("a", "c"),
        List.of("a", "b"),
        List.of("c", "b"),
        List.of("c", "d"),
        List.of("b", "d"),
        List.of("e", "d"),
        List.of("g", "f")
    );
    assertEquals(3, shortestPath(edges, "a", "e"));
    assertEquals(2, shortestPath(edges, "e", "c"));
    assertEquals(-1, shortestPath(edges, "b", "g"));

    edges = List.of(
        List.of("c", "n"),
        List.of("c", "e"),
        List.of("c", "s"),
        List.of("c", "w"),
        List.of("w", "e")
    );
    assertEquals(1, shortestPath(edges, "w", "e"));
    assertEquals(2, shortestPath(edges, "n", "e"));

    edges = List.of(
        List.of("m", "n"),
        List.of("n", "o"),
        List.of("o", "p"),
        List.of("p", "q"),
        List.of("t", "o"),
        List.of("r", "q"),
        List.of("r", "s")
    );
    assertEquals(6, shortestPath(edges, "m", "s"));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(e) <br>
   * Space Complexity: O(e) <br>
   */
  public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
    Map<String, List<String>> graph = buildGraph(edges);
    Queue<SimpleEntry<String, Integer>> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.offer(new SimpleEntry<>(nodeA, 0));
    visited.add(nodeA);
    while (!queue.isEmpty()) {
      SimpleEntry<String, Integer> entry = queue.remove();
      String node = entry.getKey();
      int distance = entry.getValue();
      if (node.equals(nodeB)) {
        return distance;
      }
      for (String neighbor : graph.get(node)) {
        if (!visited.contains(neighbor)) {
          queue.offer(new SimpleEntry<>(neighbor, distance + 1));
          visited.add(neighbor);
        }
      }
    }
    return -1;
  }

  private static Map<String, List<String>> buildGraph(List<List<String>> edges) {
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> edge : edges) {
      String a = edge.get(0);
      String b = edge.get(1);
      graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
      graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
    }
    return graph;
  }
}
