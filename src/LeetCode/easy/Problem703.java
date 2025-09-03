package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">703. Kth Largest Element in a Stream</a>
 */
public class Problem703 {

  public static void main(String[] args) {
    KthLargest kthLargest1 = new KthLargest(3, new int[] {4, 5, 8, 2});
    assertEquals(4, kthLargest1.add(3)); // return 4
    assertEquals(5, kthLargest1.add(5)); // return 5
    assertEquals(5, kthLargest1.add(10)); // return 5
    assertEquals(8, kthLargest1.add(9)); // return 8
    assertEquals(8, kthLargest1.add(4)); // return 8

    KthLargest kthLargest2 = new KthLargest(4, new int[] {7, 7, 7, 7, 8, 3});
    assertEquals(7, kthLargest2.add(2)); // return 7
    assertEquals(7, kthLargest2.add(10)); // return 7
    assertEquals(7, kthLargest2.add(9)); // return 7
    assertEquals(8, kthLargest2.add(9)); // return 8
  }

  /**
   * Your KthLargest object will be instantiated and called as such:
   * KthLargest obj = new KthLargest(k, nums);
   * int param_1 = obj.add(val);
   */
  static class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    /**
     * Approach: Heap (Priority Queue) <br>
     * Time Complexity: O((m + n) * log(k)) <br>
     * Space Complexity: O(k) <br>
     */
    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.minHeap = new PriorityQueue<>();
      for (int num : nums) {
        this.add(num);
      }
    }

    public int add(int val) {
      if (minHeap.size() < k || minHeap.peek() < val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
          minHeap.remove();
        }
      }
      return minHeap.peek();
    }
  }
}
