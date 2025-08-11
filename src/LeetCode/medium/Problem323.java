package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/">323. Number of Connected Components in an Undirected Graph</a>
 */
public class Problem323 {

  public static void main(String[] args) {
    assertEquals(2, countComponents(5, new int[][] {{0,1},{1,2},{3,4}}));
    assertEquals(1, countComponents(5, new int[][] {{0,1},{1,2},{2,3},{3,4}}));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(n + m) <-> 'n' = # of nodes & 'm' = # of edges <br>
   * Space Complexity: O(n + m) <br>
   */
  public static int countComponents(int n, int[][] edges) {
    int count = 0;
    Map<Integer, List<Integer>> graph = buildGraph(edges, n);
    Set<Integer> visited = new HashSet<>();
    for (int node = 0; node < n; node++) {
      if (traverseComponent(graph, visited, node)) {
        count++;
      }
    }
    return count;
  }

  private static boolean traverseComponent(Map<Integer, List<Integer>> graph, Set<Integer> visited, int startNode) {
    if (!visited.add(startNode)) {
      return false;
    }
    for (int neighbor : graph.get(startNode)) {
      traverseComponent(graph, visited, neighbor);
    }
    return true;
  }

  /**
   * Time Complexity: O(n + m) <-> 'n' = # of nodes & 'm' = # of edges <br>
   * Space Complexity: O(m) <br>
   */
  private static Map<Integer, List<Integer>> buildGraph(int[][] edges, int n) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
      graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
    }
    return graph;
  }
}
