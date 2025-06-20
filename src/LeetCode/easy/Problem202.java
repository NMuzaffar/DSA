package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/">202. Happy Number</a>
 */
public class Problem202 {

  public static void main(String[] args) {
    assertTrue(isHappy(19));
    assertFalse(isHappy(2));
    assertTrue(isHappy(10));
    assertTrue(isHappy(23));
    assertFalse(isHappy(116));
  }

  private static int getNextNum(int num) {
    int sum = 0;
    while (num > 0) {
      int digit = num % 10;
      sum += (int) Math.pow(digit, 2);
      num /= 10;
    }
    return sum;
  }

  /**
   * Approach: Floyd's Cycle Detection (Fast & Slow Pointers) <br>
   * Time Complexity: O(log(n)) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean isHappy(int n) {
    int slow = n;
    int fast = getNextNum(n);
    while (fast != 1 && slow != fast) {
      slow = getNextNum(slow);
      fast = getNextNum(getNextNum(fast));
    }
    return fast == 1;
  }

//  /**
//   * Approach: Hash Set <br>
//   * Time Complexity: O(log(n)) <br>
//   * Space Complexity: O(log(n)) <br>
//   */
//  public static boolean isHappy(int n) {
//    Set<Integer> seen = new HashSet<>();
//    while (n != 1 && !seen.contains(n)) {
//      seen.add(n);
//      n = getNextNum(n);
//    }
//    return n == 1;
//  }
}
