package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 */
public class Problem200 {

  public static void main(String[] args) {
    assertEquals(1, numIslands(new char[][] {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    }));
    assertEquals(3, numIslands(new char[][] {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    }));
  }

  /**
   * Approach: Graph DFS (Recursive) or Graph BFS <br>
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(m * n) <br>
   */
  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int islandsCount = 0;
    int rowLen = grid.length;
    int colLen = grid[0].length;
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (grid[row][col] == '1') {
          islandsCount++;
          dfs(grid, row, col);
          // bfs(grid, row, col);
        }
      }
    }
    return islandsCount;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static void dfs(char[][] grid, int row, int col) {
    grid[row][col] = '0';
    for (int[] direction : DIRECTIONS) {
      int nextRow = row + direction[0];
      int nextCol = col + direction[1];
      if (isValid(grid, nextRow, nextCol)) {
        grid[nextRow][nextCol] = '0';
        dfs(grid, nextRow, nextCol);
      }
    }
  }

  private static void bfs(char[][] grid, int row, int col) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {row, col});
    grid[row][col] = '0';
    while (!queue.isEmpty()) {
      int[] currNode = queue.poll();
      for (int[] direction : DIRECTIONS) {
        int nextRow = currNode[0] + direction[0];
        int nextCol = currNode[1] + direction[1];
        if (isValid(grid, nextRow, nextCol)) {
          grid[nextRow][nextCol] = '0';
          queue.offer(new int[] {nextRow, nextCol});
        }
      }
    }
  }

  private static boolean isValid(char[][] grid, int row, int col) {
    int rowLen = grid.length;
    int colLen = grid[0].length;
    return 0 <= row && row < rowLen && 0 <= col && col < colLen && grid[row][col] == '1';
  }
}
