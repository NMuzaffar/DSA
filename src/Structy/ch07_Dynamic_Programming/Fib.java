package Structy.ch07_Dynamic_Programming;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://structy.net/problems/fib">Fib</a>
 */
public class Fib {

  public static void main(String[] args) {
      assertEquals(0, fib(0));
      assertEquals(1, fib(1));
      assertEquals(1, fib(2));
      assertEquals(2, fib(3));
      assertEquals(3, fib(4));
      assertEquals(5, fib(5));
      assertEquals(9227465, fib(35));
      assertEquals(1836311903, fib(46));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int fib(int n) {
    return fibMemoized(n, new HashMap<>());
  }

  private static int fibMemoized(int n, Map<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
        return n;
    }
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    int result = fibMemoized(n - 1, memo) + fibMemoized(n - 2, memo);
    memo.put(n, result);
    return result;
  }
}
