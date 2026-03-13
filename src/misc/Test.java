package misc;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test {

  record Position(int row, int col, int moves) {}

  public static void main(String[] args) {
    int[] time = new int[] {1, 1, 1, 1};

    int[] cost = new int[] {1, 1, 1, 1};

    //        char[][] grid = {
    //                {'1', '2', '3', 'S', '1', '2', '4'},
    //                {'X', '2', '3', '2', '1', 'X', '2'},
    //                {'2', '1', '1', 'D', '2', 'X', '4'}
    //        };
    char[][] grid = {
      {'1', '2', '3', 'S', '1'},
      {'2', '4', 'X', '3', '3'},
      {'2', '1', 'X', '3', '2'},
      {'1', '1', 'D', '3', 'X'},
      {'4', '1', '3', '3', '1'}
    };

    int mode = findShortestAndCheapestRout(grid, time, cost);

    System.out.println(mode);
  }

  public static int findShortestAndCheapestRout(char[][] grid, int[] time, int[] cost) {
    if (grid == null || grid.length == 0) {
      return -1;
    }
    int rowLen = grid.length;
    int colLen = grid[0].length;

    int[] src = null;
    int[] dest = null;
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        char cell = grid[row][col];
        if (cell == 'S') {
          src = new int[] {row, col};
        } else if (cell == 'D') {
          dest = new int[] {row, col};
        }
      }
    }
    if (src == null || dest == null) {
      return -1;
    }

    int bestMode = -1;
    int bestTime = Integer.MAX_VALUE;
    int bestCost = Integer.MAX_VALUE;

    for (int mode = 1; mode <= time.length; mode++) {
      int moves = bfs(grid, src, dest, mode);
      if (moves != Integer.MAX_VALUE) {
        int totalTime = moves * time[mode - 1];
        int totalCost = time[mode - 1];

        if (totalTime < bestTime || (totalTime == bestTime && totalCost < bestCost)) {
          bestMode = mode;
          bestTime = totalTime;
          bestCost = totalCost;

          System.out.println("Number of moves: " + moves);
          System.out.println("Total travel time: " + bestTime);
        }
      }
    }

    return bestMode;
  }

  private static int bfs(char[][] grid, int[] src, int[] dest, int transportMode) {
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int rowLen = grid.length;
    int colLen = grid[0].length;

    Queue<Position> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[rowLen][colLen];
    visited[src[0]][src[1]] = true;
    queue.offer(new Position(src[0], src[1], 0));

    while (!queue.isEmpty()) {
      Position curr = queue.poll();
      if (curr.row == dest[0] && curr.col == dest[1]) {
        return curr.moves;
      }

      for (int[] direction : directions) {
        int nextRow = direction[0] + curr.row;
        int nextCol = direction[1] + curr.col;
        if (isValidPos(nextRow, nextCol, grid, transportMode) && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          queue.offer(new Position(nextRow, nextCol, curr.moves + 1));
        }
      }
    }
    return Integer.MAX_VALUE;
  }

  private static boolean isValidPos(int row, int col, char[][] grid, int transportMode) {
    return 0 <= row
        && row < grid.length
        && 0 <= col
        && col < grid[0].length
        && (grid[row][col] == 'D' || grid[row][col] == (char) ('0' + transportMode));
  }
}
