package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/01-matrix/">542. 01 Matrix</a>
 */
public class Problem542 {

  public static void main(String[] args) {
    assertTrue(Arrays.deepEquals(
        new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
        updateMatrix(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));

    assertTrue(Arrays.deepEquals(
        new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}},
        updateMatrix(new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(m * n) <br>
   */
  public static int[][] updateMatrix(int[][] mat) {
    int rowLen = mat.length;
    int colLen = mat[0].length;
    int[][] ans = new int[rowLen][colLen];
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rowLen][colLen];
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        ans[row][col] = mat[row][col];
        if (mat[row][col] == 0) {
          visited[row][col] = true;
          queue.offer(new int[] { row, col, 0 });
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] currNode = queue.poll();
      int row = currNode[0];
      int col = currNode[1];
      int steps = currNode[2];
      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        if (isValidPos(nextRow, nextCol, mat) && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          queue.offer(new int[] { nextRow, nextCol, steps + 1 });
          ans[nextRow][nextCol] = steps + 1;
        }
      }
    }
    return ans;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static boolean isValidPos(int row, int col, int[][] mat) {
    return 0 <= row && row < mat.length && 0 <= col && col < mat[0].length;
  }
}