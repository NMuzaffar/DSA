package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/">1413. Minimum Value to Get Positive Step by Step Sum</a>
 */
public class Problem1413 {

  public static void main(String[] args) {
    assertEquals(5, minStartValue(new int[] {-3,2,-3,4,2}));
    assertEquals(1, minStartValue(new int[] {1, 2}));
    assertEquals(5, minStartValue(new int[] {1, -2, -3}));
  }

  /**
   * Approach: Prefix total <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int minStartValue1(int[] nums) {


    int n = nums.length;

    int[] prefix = new int[n];
    prefix[0] = nums[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }

    int startValue = 1;
    while (true) {
      boolean allStepsPositive = false;
      for (int prefixNum : prefix) {
        if (prefixNum + startValue < 1) {
          allStepsPositive = false;
          break;
        }
        allStepsPositive = true;
      }
      if (allStepsPositive) {
        return startValue;
      }
      startValue++;
    }
  }

  /**
   * Approach: Brute Force <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static int minStartValue(int[] nums) {
    int startValue = 1;
    while (true) {
      int total = startValue;
      boolean isValid = true;

      for (int num : nums) {
        total += num;
        if (total < 1) {
          isValid = false;
          break;
        }
      }

      if (isValid) {
        return startValue;
      } else {
        startValue++;
      }
    }
  }
}
