package Structy.misc;

import static org.junit.jupiter.api.Assertions.*;

public class MaxValue {

  public static void main(String[] args) {
    assertEquals(10, maxValue(new double[] {4, 7, 2, 8, 10, 9}));
    assertEquals(40.3d, maxValue(new double[] {10, 5, 40, 40.3}));
    assertEquals(-1, maxValue(new double[] {-5, -2, -1, -11}));
    assertEquals(42, maxValue(new double[] {42}));
    assertEquals(1000, maxValue(new double[] {1000, 8}));
    assertEquals(9000, maxValue(new double[] {1000, 8, 9000}));
    assertEquals(5, maxValue(new double[] {2, 5, 1, 1, 4}));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static double maxValue(double[] numbers) {
    double max = Double.NEGATIVE_INFINITY;
    for (double num : numbers) {
      if (num > max) {
        max = num;
      }
    }
    return max;
  }
}
