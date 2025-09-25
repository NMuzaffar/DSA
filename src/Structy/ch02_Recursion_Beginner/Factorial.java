package Structy.ch02_Recursion_Beginner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://structy.net/problems/premium/factorial">Factorial</a>
 */
public class Factorial {

  public static void main(String[] args) {
    assertEquals(6L, factorial(3));
    assertEquals(720L, factorial(6));
    assertEquals(6402373705728000L, factorial(18));
    assertEquals(1L, factorial(1));
    assertEquals(6227020800L, factorial(13));
    assertEquals(1L, factorial(0));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static long factorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}
