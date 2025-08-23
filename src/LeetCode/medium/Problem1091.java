package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/">1091. Shortest Path in Binary Matrix</a>
 */
public class Problem1091 {

  public static void main(String[] args) {
    assertEquals(2, shortestPathBinaryMatrix(new int[][] {{0,1},{1,0}}));
    assertEquals(4, shortestPathBinaryMatrix(new int[][] {{0,0,0},{1,1,0},{1,1,0}}));
    assertEquals(-1, shortestPathBinaryMatrix(new int[][] {{1,0,0},{1,1,0},{1,1,0}}));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1) {
      return -1;
    }
    int n = grid.length;
    Queue<State> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    queue.offer(new State(0, 0, 1));
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      State currCell = queue.poll();
      int row = currCell.row;
      int col = currCell.col;
      int steps = currCell.steps;
      if (row == n - 1 && col == n - 1) {
        return steps;
      }
      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        if (isValidCell(nextRow, nextCol, grid) && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          queue.offer(new State(nextRow, nextCol, steps + 1));
        }
      }
    }
    return -1;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {-1,-1},
      {-1,0},
      {-1,1},
      {0,1},
      {0,-1},
      {1,-1},
      {1,0},
      {1,1},
  };

  private static boolean isValidCell(int row, int col, int[][] grid) {
    return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length && grid[row][col] == 0;
  }

  static class State {
    int row;
    int col;
    int steps;

    public State(int row, int col, int steps) {
      this.row = row;
      this.col = col;
      this.steps = steps;
    }
  }
}