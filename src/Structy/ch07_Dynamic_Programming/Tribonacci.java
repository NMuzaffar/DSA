package Structy.ch07_Dynamic_Programming;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://structy.net/problems/tribonacci">Tribonacci</a>
 */
public class Tribonacci {

  public static void main(String[] args) {
    assertEquals(0, tribonacci(0));
    assertEquals(0, tribonacci(1));
    assertEquals(1, tribonacci(2));
    assertEquals(4, tribonacci(5));
    assertEquals(13, tribonacci(7));
    assertEquals(927, tribonacci(14));
    assertEquals(35890, tribonacci(20));
    assertEquals(1132436852, tribonacci(37));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int tribonacci(int n) {
    return tribonacciMemo(n, new HashMap<>());
  }

  public static int tribonacciMemo(int n, Map<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    int result = tribonacciMemo(n - 1, memo) + tribonacciMemo(n - 2, memo) + tribonacciMemo(n - 3, memo);
    memo.put(n, result);
    return result;
  }
}
