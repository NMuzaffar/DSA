package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">1466. Reorder Routes to Make All Paths Lead to the City Zero</a>
 */
public class Problem1466 {

  public static void main(String[] args) {
    assertEquals(3, minReorder(6, new int[][] {{0,1},{1,3},{2,3},{4,0},{4,5}}));
    assertEquals(2, minReorder(5, new int[][] {{1,0},{1,2},{3,2},{3,4}}));
    assertEquals(0, minReorder(3, new int[][] {{1,0},{2,0}}));
    assertEquals(3, minReorder(6, new int[][] {{4,5},{0,1},{1,3},{2,3},{4,0}}));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int minReorder(int n, int[][] connections) {
    Set<String> roads = new HashSet<>();
    Map<Integer, List<Integer>> graph = buildGraph(connections, roads);
    boolean[] visited = new boolean[n];
    visited[0] = true;
    return dfs(0, graph, visited, roads);
  }

  private static int dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, Set<String> roads) {
    int reorderCount = 0;
    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        if (roads.contains(convertToHash(node, neighbor))) {
          reorderCount++;
        }
        reorderCount += dfs(neighbor, graph, visited, roads);
      }
    }
    return reorderCount;
  }

  private static Map<Integer, List<Integer>> buildGraph(int[][] connections, Set<String> roads) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : connections) {
      int a = edge[0];
      int b = edge[1];
      graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
      graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
      roads.add(convertToHash(a, b));
    }
    return graph;
  }

  private static String convertToHash(int a, int b) {
    return a + "#" + b;
  }
}