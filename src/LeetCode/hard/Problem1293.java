package LeetCode.hard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/">1293. Shortest Path in a Grid with Obstacles Elimination</a>
 */
public class Problem1293 {

  public static void main(String[] args) {
    assertEquals(6, shortestPath(new int[][] {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}, 1));
    assertEquals(-1, shortestPath(new int[][] {{0,1,1},{1,1,1},{1,0,0}}, 1));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(m * n * k) <br>
   * Space Complexity: O(m * n * k) <br>
   */
  public static int shortestPath(int[][] grid, int k) {
    int rowLen = grid.length;
    int colLen = grid[0].length;

    Queue<State> queue = new LinkedList<>();
    boolean[][][] visited = new boolean[rowLen][colLen][k + 1];
    queue.offer(new State(0, 0, k, 0));
    visited[0][0][k] = true;

    while (!queue.isEmpty()) {
      State state = queue.poll();
      int row = state.row;
      int col = state.col;
      int remain = state.remain;
      int steps = state.steps;
      if (row == rowLen - 1 && col == colLen - 1) {
        return steps;
      }
      for (int [] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        if (isValidCell(nextRow, nextCol, grid)) {
          if (grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][remain]) {
            visited[nextRow][nextCol][remain] = true;
            queue.offer(new State(nextRow, nextCol, remain, steps + 1));
          } else if (remain > 0 && !visited[nextRow][nextCol][remain - 1]) {
            visited[nextRow][nextCol][remain - 1] = true;
            queue.offer(new State(nextRow, nextCol, remain - 1, steps + 1));
          }
        }
      }
    }
    return -1;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1,0},
      {-1,0},
      {0,1},
      {0,-1}
  };

  private static boolean isValidCell(int row, int col, int[][] grid) {
    return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length;
  }

  static class State {
    int row;
    int col;
    int remain;
    int steps;
    State(int row, int col, int remain, int steps) {
      this.row = row;
      this.col = col;
      this.remain = remain;
      this.steps = steps;
    }
  }
}