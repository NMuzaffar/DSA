package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">973. K Closest Points to Origin</a>
 */
public class Problem973 {

  public static void main(String[] args) {
    assertTrue(Arrays.deepEquals(new int[][] {{-2,2}}, kClosest(new int[][] {{1,3},{-2,2}}, 1)));
    assertTrue(Arrays.deepEquals(new int[][] {{3,3},{-2,4}}, kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2)));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(k)) <br>
   * Space Complexity: O(k) <br>
   */
  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (p1, p2) -> Integer.compare(squaredDistance(p2), squaredDistance(p1)));
    for (int[] point : points) {
      maxHeap.add(point);
      if (maxHeap.size() > k) {
        maxHeap.remove();
      }
    }
    int[][] ans = new int[k][2];
    for (int i = k - 1; i >= 0; i--) {
      ans[i] = maxHeap.remove();
    }
    return ans;
  }

  private static int squaredDistance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }
}
