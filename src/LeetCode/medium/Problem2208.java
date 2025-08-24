package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-halve-array-sum/">2208. Minimum Operations to Halve Array Sum</a>
 */
public class Problem2208 {

  public static void main(String[] args) {
    assertEquals(3, halveArray(new int[] {5,19,8,1}));
    assertEquals(3, halveArray(new int[] {3,8,20}));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(n)) <br>
   * Space Complexity: O(n) <br>
   */
  public static int halveArray(int[] nums) {
    double totalSum = 0;
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (double num : nums) {
      totalSum += num;
      maxHeap.add(num);
    }
    int opsCount = 0;
    double targetSum = totalSum / 2;
    while (targetSum > 0) {
      double topVal = maxHeap.remove();
      targetSum -= (topVal / 2);
      maxHeap.add(topVal / 2);
      opsCount++;
    }
    return opsCount;
  }
}