package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>
 */
public class Problem215 {

  public static void main(String[] args) {
    assertEquals(5, findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    assertEquals(4, findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    assertEquals(99, findKthLargest(new int[] {99,99}, 1));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(k)) <br>
   * Space Complexity: O(k) <br>
   */
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.remove();
      }
    }
    return minHeap.peek();
  }

//  /**
//   * Approach: Counting Sort <br>
//   * Time Complexity: O(n + m)  <-> 'm' = maxValue - minValue <br>
//   * Space Complexity: O(m) <br>
//   */
//  public static int findKthLargest(int[] nums, int k) {
//    int minVal = Integer.MAX_VALUE;
//    int maxVal = Integer.MIN_VALUE;
//    for (int num : nums) {
//      minVal = Math.min(minVal, num);
//      maxVal = Math.max(maxVal, num);
//    }
//    int[] count = new int[maxVal - minVal + 1];
//    for (int num : nums) {
//      count[num - minVal]++;
//    }
//    int seen = 0;
//    for (int num = count.length - 1; num >= 0; num--) {
//      seen += count[num];
//      if (seen >= k) {
//        return num + minVal;
//      }
//    }
//    return -1;
//  }
}
