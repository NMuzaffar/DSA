package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/find-the-highest-altitude/">1732. Find the Highest Altitude</a>
 */
public class Problem1732 {

  public static void main(String[] args) {
    assertEquals(1, largestAltitude(new int[] {-5,1,5,0,-7}));
    assertEquals(0, largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
  }

  /**
   * Approach: Prefix Sum <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int largestAltitude(int[] gain) {
    int currAltitude = 0;
    int highestPoint = currAltitude;

    for (int altitudeGain : gain) {
      currAltitude += altitudeGain;
      highestPoint = Math.max(highestPoint, currAltitude);
    }

    return highestPoint;
  }
}
