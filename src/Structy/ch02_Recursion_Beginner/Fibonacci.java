package Structy.ch02_Recursion_Beginner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/premium/fibonacci">Fibonacci</a>
 */
public class Fibonacci {

  public static void main(String[] args) {
    assertEquals(0, fibonacci(0));
    assertEquals(1, fibonacci(1));
    assertEquals(1, fibonacci(2));
    assertEquals(2, fibonacci(3));
    assertEquals(3, fibonacci(4));
    assertEquals(5, fibonacci(5));
    assertEquals(21, fibonacci(8));
  }

  /**
   * Time Complexity: O(2^n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
