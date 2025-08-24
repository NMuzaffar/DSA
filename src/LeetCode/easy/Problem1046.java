package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">1046. Last Stone Weight</a>
 */
public class Problem1046 {

  public static void main(String[] args) {
    assertEquals(1, lastStoneWeight(new int[] {2,7,4,1,8,1}));
    assertEquals(1, lastStoneWeight(new int[] {1}));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(n)) <br>
   * Space Complexity: O(n) <br>
   */
  public static int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int stone : stones) {
      maxHeap.add(stone);
    }
    while (maxHeap.size() > 1) {
      int x = maxHeap.remove();
      int y = maxHeap.remove();
      if (x != y) {
        maxHeap.add(x - y);
      }
    }
    return maxHeap.isEmpty() ? 0 : maxHeap.remove();
  }
}
