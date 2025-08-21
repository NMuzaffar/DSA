package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-path-to-get-food/">1730. Shortest Path to Get Food</a>
 */
public class Problem1730 {

  public static void main(String[] args) {
    assertEquals(3, getFood(new char[][] {
        {'X','X','X','X','X','X'},
        {'X','*','O','O','O','X'},
        {'X','O','O','#','O','X'},
        {'X','X','X','X','X','X'}
    }));

    assertEquals(-1, getFood(new char[][] {
        {'X','X','X','X','X'},
        {'X','*','X','O','X'},
        {'X','O','X','#','X'},
        {'X','X','X','X','X'}
    }));

    assertEquals(6, getFood(new char[][] {
        {'X','X','X','X','X','X','X','X'},
        {'X','*','O','X','O','#','O','X'},
        {'X','O','O','X','O','O','X','X'},
        {'X','O','O','O','O','#','O','X'},
        {'X','X','X','X','X','X','X','X'}
    }));

    assertEquals(6, getFood(new char[][] {
        {'X','X','X','X','X','X','X','X'},
        {'X','*','O','X','O','#','O','X'},
        {'X','O','O','X','O','O','X','X'},
        {'X','O','O','O','O','#','O','X'},
        {'O','O','O','O','O','O','O','O'}
    }));

    assertEquals(5, getFood(new char[][] {
        {'X','X','X','X','X'},
        {'X','*','X','O','X'},
        {'X','O','X','#','X'},
        {'O','O','O','O','O'}
    }));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(m * n) <br>
   */
  public static int getFood(char[][] grid) {
    int rowLen = grid.length;
    int colLen = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rowLen][colLen];

    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (grid[row][col] == '*') {
          visited[row][col] = true;
          queue.offer(new int[] {row, col});
          break;
        }
      }
    }

    int distance = 0;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        int[] position = queue.poll();
        int row = position[0];
        int col = position[1];
        if (grid[row][col] == '#') {
          return distance;
        }
        for (int[] direction : DIRECTIONS) {
          int nextRow = row + direction[0];
          int nextCol = col + direction[1];
          if (isValidPos(nextRow, nextCol, grid) && !visited[nextRow][nextCol]) {
            visited[nextRow][nextCol] = true;
            queue.add(new int[] {nextRow, nextCol});
          }
        }
      }
      distance++;
    }
    return -1;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static boolean isValidPos(int row, int col, char[][] grid) {
    return 0 <= row && 0 <= col && row < grid.length && col < grid[0].length && grid[row][col] != 'X';
  }
}