package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/">1985. Find the Kth Largest Integer in the Array</a>
 */
public class Problem1985 {

  public static void main(String[] args) {
    assertEquals("3", kthLargestNumber(new String[] {"3","6","7","10"}, 4));
    assertEquals("2", kthLargestNumber(new String[] {"2","21","12","1"}, 3));
    assertEquals("0", kthLargestNumber(new String[] {"0","0"}, 2));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(k)) <br>
   * Space Complexity: O(k) <br>
   */
  public static String kthLargestNumber(String[] nums, int k) {
    PriorityQueue<String> minHeap = new PriorityQueue<>(
        (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length()));
    for (String num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.remove();
      }
    }
    return minHeap.peek();
  }
}
