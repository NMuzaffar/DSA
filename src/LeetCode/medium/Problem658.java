package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-k-closest-elements/">658. Find K Closest Elements</a>
 */
public class Problem658 {

  public static void main(String[] args) {
    assertEquals(List.of(1,2,3,4), findClosestElements(new int[] {1,2,3,4,5}, 4, 3));
    assertEquals(List.of(1,1,2,3), findClosestElements(new int[] {1,1,2,3,4,5}, 4, -1));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O((n + k) * log(k)) <br>
   * Space Complexity: O(k) <br>
   */
  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a - x) == Math.abs(b - x)) {
        return b - a;
      }
      return Math.abs(b - x) - Math.abs(a - x);
    });
    for (int num : arr) {
      maxHeap.add(num);
      if (maxHeap.size() > k) {
        maxHeap.remove();
      }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ans.add(maxHeap.remove());
    }
    Collections.sort(ans);
    return ans;
  }
}
