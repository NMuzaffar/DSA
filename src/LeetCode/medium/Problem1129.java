package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/">1129. Shortest Path with Alternating Colors</a>
 */
public class Problem1129 {

  public static void main(String[] args) {
    assertArrayEquals(new int[] {0,1,-1},
        shortestAlternatingPaths(3,
            new int[][] {{0,1},{1,2}},
            new int[][] {}));

    assertArrayEquals(new int[] {0,1,-1},
        shortestAlternatingPaths(3,
            new int[][] {{0,1}},
            new int[][] {{2,1}}));

    assertArrayEquals(new int[] {0,-1,-1},
        shortestAlternatingPaths(3,
            new int[][] {{1,0}},
            new int[][] {{2,1}}));

    assertArrayEquals(new int[] {0,1,2,3,7},
        shortestAlternatingPaths(5,
            new int[][] {{0,1},{1,2},{2,3},{3,4}},
            new int[][] {{1,2},{2,3},{3,1}}));

    assertArrayEquals(new int[] {0,1,2,2,1},
        shortestAlternatingPaths(5,
            new int[][] {{2,2},{0,4},{4,2},{4,3},{2,4},{0,0},{0,1},{2,3},{1,3}},
            new int[][] {{0,4},{1,0},{1,4},{0,0},{4,0}}));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(n + e) <br>
   * Space Complexity: O(n + e) <br>
   */
  public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    List<Integer>[] redGraph = buildGraph(redEdges, n);
    List<Integer>[] blueGraph = buildGraph(blueEdges, n);

    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    Queue<State> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][2];
    queue.offer(new State(0, 0, 0));
    queue.offer(new State(0, 1, 0));
    visited[0][0] = true;
    visited[0][1] = true;
    ans[0] = 0;

    while (!queue.isEmpty()) {
      State state = queue.poll();
      int node = state.node;
      int prevColor = state.prevColor;
      int steps = state.steps;
      int nextColor = 1 - prevColor;
      for (int neighbor : (nextColor == 0) ? redGraph[node] : blueGraph[node]) {
        if (!visited[neighbor][nextColor]) {
          if (ans[neighbor] == -1) {
            ans[neighbor] = steps + 1;
          }
          visited[neighbor][nextColor] = true;
          queue.offer(new State(neighbor, nextColor, steps + 1));
        }
      }
    }
    return ans;
  }

  private static List<Integer>[] buildGraph(int[][] edges, int n) {
    List<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];
      graph[x].add(y);
    }
    return graph;
  }

  static class State {
    int node;
    int prevColor; // RED <=> 0; BLUE <=> 1
    int steps;

    State(int node, int prevColor, int steps) {
      this.node = node;
      this.prevColor = prevColor;
      this.steps = steps;
    }
  }
}