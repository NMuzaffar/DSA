package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">695. Max Area of Island</a>
 */
public class Problem695 {

  public static void main(String[] args) {
    assertEquals(6, maxAreaOfIsland(new int[][] {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
    }));

    assertEquals(6, maxAreaOfIsland(new int[][] {
        {0,0,0,0,0,0,0,0},
    }));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(m * n) <br>
   */
  public static int maxAreaOfIsland(int[][] grid) {
    int rowLen = grid.length;
    int colLen = grid[0].length;
    int maxArea = 0;
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (grid[row][col] != 0) {
          grid[row][col] = 0;
          int islandArea = traverseIslandArea(grid, row, col);
          maxArea = Math.max(maxArea, islandArea);
        }
      }
    }
    return maxArea;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static int traverseIslandArea(int[][] grid, int row, int col) {
    int area = 1;
    for (int[] direction : DIRECTIONS) {
      int nextRow = row + direction[0];
      int nextCol = col + direction[1];
      if (isValidIsland(grid, nextRow, nextCol)) {
        grid[nextRow][nextCol] = 0;
        area += traverseIslandArea(grid, nextRow, nextCol);
      }
    }
    return area;
  }

  private static boolean isValidIsland(int[][] grid, int row, int col) {
    return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length && grid[row][col] == 1;
  }
}
