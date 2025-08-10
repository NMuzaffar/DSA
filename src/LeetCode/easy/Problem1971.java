package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">1971. Find if Path Exists in Graph</a>
 */
public class Problem1971 {

  public static void main(String[] args) {
    assertTrue(validPath(3, new int[][] {{0,1},{1,2},{2,0}}, 0, 2));
    assertFalse(validPath(6, new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(n + m) <-> 'n' = # of nodes & 'm' = # of edges <br>
   * Space Complexity: O(n + m) <br>
   */
  public static boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, List<Integer>> graph = buildGraph(edges);
    Set<Integer> visited = new HashSet<>();
    return dfs(graph, source, destination, visited);
  }

  private static boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, Set<Integer> visited) {
    if (source == destination) {
      return true;
    }
    if (!visited.add(source)) {
      return false;
    }
    for (int neighbor : graph.get(source)) {
      if (dfs(graph, neighbor, destination, visited)) {
        return true;
      }
    }
    return false;
  }

//  /**
//   * Approach: Graph BFS <br>
//   * Time Complexity: O(n + m) <-> 'n' = # of nodes & 'm' = # of edges <br>
//   * Space Complexity: O(n + m) <br>
//   */
//  public static boolean validPath(int n, int[][] edges, int source, int destination) {
//    Map<Integer, List<Integer>> graph = buildGraph(edges);
//    Queue<Integer> queue = new ArrayDeque<>();
//    Set<Integer> visited = new HashSet<>();
//    queue.add(source);
//    visited.add(source);
//    while (!queue.isEmpty()) {
//      int currNode = queue.remove();
//      if (currNode == destination) {
//        return true;
//      }
//      for (int neighbor : graph.get(currNode)) {
//        if (!visited.contains(neighbor)) {
//          visited.add(neighbor);
//          queue.add(neighbor);
//        }
//      }
//    }
//    return false;
//  }

  /**
   * Time Complexity: O(m) <-> 'm' = # of edges <br>
   * Space Complexity: O(m) <br>
   */
  private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
      graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
    }
    return graph;
  }
}
