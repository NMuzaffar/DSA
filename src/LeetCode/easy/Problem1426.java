package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/counting-elements/">1426. Counting Elements</a>
 */
public class Problem1426 {

  public static void main(String[] args) {
    assertEquals(2, countElements(new int[] {1,2,3}));
    assertEquals(0, countElements(new int[] {1,1,3,3,5,5,7,7}));
  }

  /**
   * Approach: HashSet </><br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int countElements(int[] arr) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : arr) {
      numSet.add(num);
    }
    int validElements = 0;
    for (int num : arr) {
      if (numSet.contains(num + 1)) {
        validElements++;
      }
    }
    return validElements;
  }
}
