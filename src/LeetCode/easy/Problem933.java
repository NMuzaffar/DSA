package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-recent-calls/">933. Number of Recent Calls</a>
 */
public class Problem933 {

  /**
   * Your RecentCounter object will be instantiated and called as such:
   * RecentCounter obj = new RecentCounter();
   * int param_1 = obj.ping(t);
   */
  public static void main(String[] args) {
    RecentCounter recentCounter = new RecentCounter();
    assertEquals(1, recentCounter.ping(1));
    assertEquals(2, recentCounter.ping(100));
    assertEquals(3, recentCounter.ping(3001));
    assertEquals(3, recentCounter.ping(3002));
  }

  /**
   * Approach: Queue <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  static class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
      queue = new LinkedList<>();
    }

    public int ping(int t) {
      queue.offer(t);
      while (!queue.isEmpty() && queue.peek() < t - 3000) {
        queue.poll();
      }
      return queue.size();
    }
  }
}
