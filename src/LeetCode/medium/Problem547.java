package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
 */
public class Problem547 {

  public static void main(String[] args) {
    assertEquals(2, findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    assertEquals(3, findCircleNum(new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
  }

  /**
   * Approach: Graph DFS (Recursive) or Graph BFS <br>
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n) <br>
   */
  public static int findCircleNum(int[][] isConnected) {
    int provincesCount = 0;
    int n = isConnected.length;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        provincesCount++;
        dfs(isConnected, visited, i);
        // bfs(isConnected, visited, i);
      }
    }
    return provincesCount;
  }

  private static void dfs(int[][] isConnected, boolean[] visited, int node) {
    visited[node] = true;
    for (int i = 0; i < isConnected.length; i++) {
      if (!visited[i] && isConnected[node][i] == 1) {
        dfs(isConnected, visited, i);
      }
    }
  }

  private static void bfs(int[][] isConnected, boolean[] visited, int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;
    while (!queue.isEmpty()) {
      node = queue.poll();
      for (int i = 0; i < isConnected.length; i++) {
        if (!visited[i] && isConnected[node][i] == 1) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }
}
