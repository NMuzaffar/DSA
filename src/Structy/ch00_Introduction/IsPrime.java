package Structy.ch00_Introduction;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/is-prime">Is Prime</a>
 */
public class IsPrime {

  public static void main(String[] args) {
    assertTrue(isPrime(2));
    assertTrue(isPrime(3));
    assertFalse(isPrime(4));
    assertTrue(isPrime(5));
    assertFalse(isPrime(6));
    assertTrue(isPrime(7));
    assertFalse(isPrime(8));
    assertFalse(isPrime(25));
    assertTrue(isPrime(31));
    assertTrue(isPrime(2017));
    assertFalse(isPrime(2048));
    assertFalse(isPrime(1));
    assertFalse(isPrime(713));
  }

  /**
   * Time Complexity: O(sqrt(n)) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
