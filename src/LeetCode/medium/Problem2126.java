package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/destroying-asteroids/">2126. Destroying Asteroids</a>
 */
public class Problem2126 {

  public static void main(String[] args) {
      assertTrue(asteroidsDestroyed(10, new int[] {3,9,19,5,21}));
      assertTrue(asteroidsDestroyed(5, new int[] {4,9,23,4}));
  }

  /**
   * Approach: Sort + Greedy <br>
   * Time Complexity: O(n * log(n)) <br>
   * Space Complexity: O(log(n)) <br>
   */
  public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
    long currMass = mass;
    Arrays.sort(asteroids);
    for (int asteroid : asteroids) {
      if (asteroid > currMass) {
        return false;
      }
      currMass += asteroid;
    }
    return true;
  }
}
