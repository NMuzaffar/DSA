package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reachable-nodes-with-restrictions/">2368. Reachable Nodes With Restrictions</a>
 */
public class Problem2368 {

  public static void main(String[] args) {
    assertEquals(4, reachableNodes(7, new int[][] {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[] {4,5}));
    assertEquals(3, reachableNodes(7, new int[][] {{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}}, new int[] {4,2,1}));
  }

  /**
   * Approach: Graph DFS (Recursive) or Graph BFS <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int reachableNodes(int n, int[][] edges, int[] restricted) {
    List<Integer>[] graph = buildGraph(edges, n);
    boolean[] visited = new boolean[n];
    for (int restrictedNode : restricted) {
      visited[restrictedNode] = true;
    }
    return bfs(0, graph, visited);
    // return dfs(0, graph, visited);
  }

  private static int bfs(int node, List<Integer>[] graph, boolean[] visited) {
    int ans = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(node);
    visited[node] = true;
    while (!queue.isEmpty()) {
      int currNode = queue.poll();
      ans++;
      for (int neighbor : graph[currNode]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }
    return ans;
  }

  private static int dfs(int node, List<Integer>[] graph, boolean[] visited) {
    visited[node] = true;
    int ans = 1;
    for (int neighbor : graph[node]) {
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        ans += dfs(neighbor, graph, visited);
      }
    }
    return ans;
  }

  private static List<Integer>[] buildGraph(int[][] edges, int n) {
    List<Integer>[] adjList = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      adjList[a].add(b);
      adjList[b].add(a);
    }
    return adjList;
  }
}
