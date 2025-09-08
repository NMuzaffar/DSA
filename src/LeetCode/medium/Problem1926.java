//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/">1926. Nearest Exit from Entrance in Maze</a>
// */
//public class Problem1926 {
//
//  public static void main(String[] args) {
//    assertEquals(-1, -1);
//  }
//
//  /**
//   * Approach: Graph BFS <br>
//   * Time Complexity: O(m * n) <br>
//   * Space Complexity: O(m * n) <br>
//   */
//  public static int nearestExit(char[][] maze, int[] entrance) {
//    int rowLen = maze.length;
//    int colLen = maze[0].length;
//
//    int startRow = entrance[0];
//    int startCol = entrance[1];
//
//    Queue<int[]> queue = new LinkedList<>();
//    boolean[][] visited = new boolean[rowLen][colLen];
//    queue.offer(new int[] { startRow, startCol, 0 });
//    visited[startRow][startCol] = true;
//    while (!queue.isEmpty()) {
//      int[] currNode = queue.poll();
//      int row = currNode[0];
//      int col = currNode[1];
//      int distance = currNode[2];
//      if (!(startRow == row && startCol == col) && isOnBorder(row, col, maze)) {
//        return distance;
//      }
//      for (int[] direction : DIRECTIONS) {
//        int nextRow = row + direction[0];
//        int nextCol = col + direction[1];
//        if (isValidCell(nextRow, nextCol, maze) && !visited[nextRow][nextCol]) {
//          visited[nextRow][nextCol] = true;
//          queue.offer(new int[] { nextRow, nextCol, distance + 1 });
//        }
//      }
//    }
//    return -1;
//  }
//
//  private static final int[][] DIRECTIONS = new int[][] {
//      { 1, 0 },
//      { -1, 0 },
//      { 0, 1 },
//      { 0, -1 }
//  };
//
//  private static boolean isOnBorder(int row, int col, char[][] maze) {
//    return 0 == row || row == maze.length - 1 || 0 == col || col == maze[0].length - 1;
//  }
//
//  private static boolean isValidCell(int row, int col, char[][] maze) {
//    return 0 <= row && row < maze.length && 0 <= col && col < maze[0].length && maze[row][col] == '.';
//  }
//}
