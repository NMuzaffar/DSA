package Structy.ch06_Graph_I;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

/**
 * <a href="https://structy.net/problems/premium/closest-carrot">Closest Carrot</a>
 */
public class ClosestCarrot {

  public static void main(String[] args) {
    assertEquals(4, closestCarrot(List.of(
        List.of("O", "O", "O", "O", "O"),
        List.of("O", "X", "O", "O", "O"),
        List.of("O", "X", "X", "O", "O"),
        List.of("O", "X", "C", "O", "O"),
        List.of("O", "X", "X", "O", "O"),
        List.of("C", "O", "O", "O", "O")
    ), 1, 2));

    assertEquals(5, closestCarrot(List.of(
        List.of("O", "O", "O", "O", "O"),
        List.of("O", "X", "O", "O", "O"),
        List.of("O", "X", "X", "O", "O"),
        List.of("O", "X", "C", "O", "O"),
        List.of("O", "X", "X", "O", "O"),
        List.of("C", "O", "O", "O", "O")
    ), 0, 0));

    assertEquals(9, closestCarrot(List.of(
        List.of("O", "O", "X", "X", "X"),
        List.of("O", "X", "X", "X", "C"),
        List.of("O", "X", "O", "X", "X"),
        List.of("O", "O", "O", "O", "O"),
        List.of("O", "X", "X", "X", "X"),
        List.of("O", "O", "O", "O", "O"),
        List.of("O", "O", "C", "O", "O"),
        List.of("O", "O", "O", "O", "O")
    ), 3, 4));

    assertEquals(2, closestCarrot(List.of(
        List.of("O", "O", "X", "O", "O"),
        List.of("O", "X", "X", "X", "O"),
        List.of("O", "X", "C", "C", "O")
    ), 1, 4));

    assertEquals(-1, closestCarrot(List.of(
        List.of("O", "O", "X", "O", "O"),
        List.of("O", "X", "X", "X", "O"),
        List.of("O", "X", "C", "C", "O")
    ), 2, 0));

    assertEquals(-1, closestCarrot(List.of(
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "X"),
        List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "C")
    ), 0, 0));

    assertEquals(5, closestCarrot(List.of(
        List.of("O", "O", "X", "C", "O"),
        List.of("O", "X", "X", "X", "O"),
        List.of("C", "X", "O", "O", "O")
    ), 2, 2));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(m * n) <br>
   */
  public static int closestCarrot(List<List<String>> grid, int startRow, int startCol) {
    Queue<SimpleEntry<List<Integer>, Integer>> queue = new LinkedList<>();
    Set<List<Integer>> visited = new HashSet<>();
    queue.offer(new SimpleEntry<>(List.of(startRow, startCol), 0));
    visited.add(List.of(startRow, startCol));
    while (!queue.isEmpty()) {
      SimpleEntry<List<Integer>, Integer> entry = queue.remove();
      int row = entry.getKey().get(0);
      int col = entry.getKey().get(1);
      int distance = entry.getValue();
      if (grid.get(row).get(col).equals("C")) {
        return distance;
      }
      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        List<Integer> newPosition = List.of(nextRow, nextCol);
        if (isValidPos(nextRow, nextCol, grid) && !visited.contains(newPosition)) {
          visited.add(newPosition);
          queue.offer(new SimpleEntry<>(newPosition, distance + 1));
        }
      }
    }
    return -1;
  }

  private static final int[][] DIRECTIONS = new int[][] {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static boolean isValidPos(int row, int col, List<List<String>> grid) {
    return 0 <= row && row < grid.size()
        && 0 <= col && col < grid.get(0).size()
        && !grid.get(row).get(col).equals("X");
  }
}
