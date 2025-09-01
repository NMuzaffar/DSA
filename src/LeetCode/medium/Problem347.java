package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
 */
public class Problem347 {

  public static void main(String[] args) {
    assertArrayEqualElements(new int[] {1,2}, topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    assertArrayEqualElements(new int[] {1}, topKFrequent(new int[] {1}, 1));
    assertArrayEqualElements(new int[] {1,2}, topKFrequent(new int[] {1,2,1,2,1,2,3,1,3,2}, 2));
  }

  private static void assertArrayEqualElements(int[] expected, int[] actual) {
    Arrays.sort(expected);
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(k)) <br>
   * Space Complexity: O(n + k) <br>
   */
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numCounts = new HashMap<>();
    for (int num : nums) {
      numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        (a, b) -> numCounts.get(a) - numCounts.get(b));
    for (int num : numCounts.keySet()) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.remove();
      }
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = minHeap.remove();
    }
    return ans;
  }
}
