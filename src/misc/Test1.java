package misc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test1 {

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

    int mode = dijkstraWithSwitching(grid, time, cost);

    System.out.println(mode);
  }

  private static int dijkstraWithSwitching(char[][] grid, int[] time, int[] cost) {
    int rows = grid.length;
    int cols = grid[0].length;
    int numModes = time.length;

    // Find source and destination
    int[] start = null, end = null;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 'S') start = new int[] {i, j};
        if (grid[i][j] == 'D') end = new int[] {i, j};
      }
    }

    if (start == null || end == null) return -1;

    // dist[row][col][mode] = minimum cost to reach (row, col) using mode
    int[][][] dist = new int[rows][cols][numModes + 1];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        Arrays.fill(dist[i][j], Integer.MAX_VALUE);
      }
    }

    PriorityQueue<State> pq = new PriorityQueue<>();

    // Start with all modes from source (pay initial cost for each mode)
    for (int mode = 1; mode <= numModes; mode++) {
      int initialCost = cost[mode - 1];
      pq.offer(new State(start[0], start[1], mode, initialCost));
      dist[start[0]][start[1]][mode] = initialCost;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int minCost = Integer.MAX_VALUE;
    int bestMode = -1;

    while (!pq.isEmpty()) {
      State curr = pq.poll();

      // If we've found a better path already, skip
      if (curr.time > dist[curr.row][curr.col][curr.mode]) {
        continue;
      }

      // Check if reached destination
      if (curr.row == end[0] && curr.col == end[1]) {
        if (curr.time < minCost) {
          minCost = curr.time;
          bestMode = curr.mode;
        }
        continue;
      }

      // Try all 4 directions
      for (int[] dir : directions) {
        int newRow = curr.row + dir[0];
        int newCol = curr.col + dir[1];

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
          char cell = grid[newRow][newCol];

          if (cell != 'X') {
            // Can move if: destination, source, or same mode
            if (cell == 'D' || cell == 'S' || cell == (char) ('0' + curr.mode))
            {
              int moveCost = curr.time + time[curr.mode - 1];

              // Try continuing with same mode (no additional cost)
              if (moveCost < dist[newRow][newCol][curr.mode]) {
                dist[newRow][newCol][curr.mode] = moveCost;
                pq.offer(new State(newRow, newCol, curr.mode, moveCost));
              }

              // Try switching to other modes at this cell (add mode cost)
              if (cell == 'S' || cell == 'D')
              {
                for (int newMode = 1; newMode <= numModes; newMode++) {
                  if (newMode != curr.mode) {
                    // Switching adds the cost[newMode] penalty
                    int switchCost = moveCost + cost[newMode - 1];

                    if (switchCost < dist[newRow][newCol][newMode]) {
                      dist[newRow][newCol][newMode] = switchCost;
                      pq.offer(new State(newRow, newCol, newMode, switchCost));
                    }
                  }
                }
              }

            }

          }
        }
      }
    }

    return bestMode;
  }

  record State(int row, int col, int mode, int time) implements Comparable<State> {
    @Override
    public int compareTo(State other) {
      return Integer.compare(this.time, other.time);
    }
  }
}
