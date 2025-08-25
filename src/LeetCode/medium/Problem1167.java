package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-connect-sticks/">1167. Minimum Cost to Connect Sticks</a>
 */
public class Problem1167 {

  public static void main(String[] args) {
    assertEquals(14, connectSticks(new int[] {2,4,3}));
    assertEquals(30, connectSticks(new int[] {1,8,3,5}));
    assertEquals(0, connectSticks(new int[] {5}));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(n)) <br>
   * Space Complexity: O(n) <br>
   */
  public static int connectSticks(int[] sticks) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int stick : sticks) {
      minHeap.add(stick);
    }
    int totalCost = 0;
    while (minHeap.size() > 1) {
      int x = minHeap.remove();
      int y = minHeap.remove();
      int currCost = x + y;
      minHeap.add(currCost);
      totalCost += currCost;
    }
    return totalCost;
  }
}
