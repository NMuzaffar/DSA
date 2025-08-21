package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/minimum-island">Minimum Island</a>
 */
public class MinimumIsland {

  public static void main(String[] args) {
    assertEquals(2, minimumIsland(List.of(
        List.of("W", "L", "W", "W", "W"),
        List.of("W", "L", "W", "W", "W"),
        List.of("W", "W", "W", "L", "W"),
        List.of("W", "W", "L", "L", "W"),
        List.of("L", "W", "W", "L", "L"),
        List.of("L", "L", "W", "W", "W")
    )));

    assertEquals(1, minimumIsland(List.of(
        List.of("L", "W", "W", "L", "W"),
        List.of("L", "W", "W", "L", "L"),
        List.of("W", "L", "W", "L", "W"),
        List.of("W", "W", "W", "W", "W"),
        List.of("W", "W", "L", "L", "L")
    )));

    assertEquals(9, minimumIsland(List.of(
        List.of("L", "L", "L"),
        List.of("L", "L", "L"),
        List.of("L", "L", "L")
    )));

    assertEquals(1, minimumIsland(List.of(
        List.of("W", "W"),
        List.of("L", "L"),
        List.of("W", "W"),
        List.of("W", "L")
    )));
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(m * n) <br>
   */
  public static int minimumIsland(List<List<String>> grid) {
    int smallest = Integer.MAX_VALUE;
    int rowLen = grid.size();
    int colLen = grid.get(0).size();
    boolean[][] visited = new boolean[rowLen][colLen];
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (!visited[row][col] && grid.get(row).get(col).equals("L")) {
          visited[row][col] = true;
          smallest = Math.min(smallest, exploreIslandSize(row, col, grid, visited));
        }
      }
    }
    return smallest;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static int exploreIslandSize(int row, int col, List<List<String>> grid, boolean[][] visited) {
    int size = 1;
    for (int[] direction : DIRECTIONS) {
      int nextRow = row + direction[0];
      int nextCol = col + direction[1];
      if (isValidPos(grid, nextRow, nextCol) && !visited[nextRow][nextCol]) {
        visited[nextRow][nextCol] = true;
        size += exploreIslandSize(nextRow, nextCol, grid, visited);
      }
    }
    return size;
  }

  private static boolean isValidPos(List<List<String>> grid, int row, int col) {
    return 0 <= row && row < grid.size()
        && 0 <= col && col < grid.get(0).size()
        && grid.get(row).get(col).equals("L");
  }
}
