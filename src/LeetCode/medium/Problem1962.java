package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/remove-stones-to-minimize-the-total/">1962. Remove Stones to Minimize the Total</a>
 */
public class Problem1962 {

  public static void main(String[] args) {
    assertEquals(12, minStoneSum(new int[] {5,4,9}, 2));
    assertEquals(12, minStoneSum(new int[] {4,3,6,7}, 3));
    assertEquals(1, minStoneSum(new int[] {10000}, 10000));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O((n + k) * log(n)) <br>
   * Space Complexity: O(n) <br>
   */
  public static int minStoneSum(int[] piles, int k) {
    int total = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int num : piles) {
      maxHeap.add(num);
      total += num;
    }
    for (int i = 0; i < k; i++) {
      int curr = maxHeap.remove();
      int remove = curr / 2;
      maxHeap.offer(curr - remove);
      total -= curr / 2;
    }
    return total;
  }
}
