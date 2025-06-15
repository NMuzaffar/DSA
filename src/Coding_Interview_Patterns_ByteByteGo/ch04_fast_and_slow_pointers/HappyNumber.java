package Coding_Interview_Patterns_ByteByteGo.ch04_fast_and_slow_pointers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/fast-and-slow-pointers/happy-number">Happy Number</a>
 */
public class HappyNumber {

  public static void main(String[] args) {
    assertTrue(happyNumber(23));
    assertFalse(happyNumber(116));
  }

  /**
   * Approach: Floyd's Cycle Detection (Fast & Slow Pointers) <br>
   * Time Complexity: O(log(n)) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean happyNumber(int n) {
    int slow = n;
    int fast = n;
    while (true) {
      slow = getNextNum(slow);
      fast = getNextNum(getNextNum(fast));
      if (fast == 1) return true;
      // If the fast and slow pointers meet, a cycle is detected.
      // Hence, 'n' is not a happy number.
      else if (fast == slow) return false;
    }
  }

  /**
   * Time Complexity: O(log(n)) <br>
   * Space Complexity: O(1) <br>
   */
  private static int getNextNum(int x) {
    int nextNum = 0;
    while (x > 0) {
      // Extract the last digit of 'x'.
      int digit = x % 10;
      // Truncate (remove) the last digit from 'x' using floor division.
      x /= 10;
      // Add the square of the extracted digit to the sum.
      nextNum += (int) Math.pow(digit, 2);
    }
    return nextNum;
  }
}
