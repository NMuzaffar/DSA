package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">2352. Equal Row and Column Pairs</a>
 */
public class Problem2352 {

  public static void main(String[] args) {
    assertEquals(1, equalPairs(new int[][] {{3,2,1},{1,7,6},{2,7,7}}));
    assertEquals(3, equalPairs(new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    assertEquals(3, equalPairs(new int[][] {{3,1,2,2},{1,4,4,4},{2,4,2,2},{2,5,2,2}}));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static int equalPairs(int[][] grid) {
    int pairs = 0;
    int n = grid.length;
    Map<String, Integer> rowsCounter = new HashMap<>();
    for (int[] row : grid) {
      String rowStr = Arrays.toString(row);
      rowsCounter.put(rowStr, rowsCounter.getOrDefault(rowStr, 0) + 1);
    }
    for (int c = 0; c < n; c++) {
      int[] colArray = new int[n];
      for (int r = 0; r < n; r++) {
        colArray[r] = grid[r][c];
      }
      String colStr = Arrays.toString(colArray);
      pairs += rowsCounter.getOrDefault(colStr, 0);
    }
    return pairs;
  }

//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n^3) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int equalPairs(int[][] grid) {
//    int pairs = 0;
//    int n = grid.length;
//    for (int r = 0; r < n; r++) {
//      for (int c = 0; c < n; c++) {
//        boolean match = true;
//        for (int i = 0; i < n; i++) {
//          if (grid[r][i] != grid[i][c]) {
//            match = false;
//            break;
//          }
//        }
//        pairs += match ? 1 : 0;
//      }
//    }
//    return pairs;
//  }
}
