//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * <a href="https://leetcode.com/problems/number-of-recent-calls/">933. Number of Recent Calls</a>
// */
//public class Problem933 {
//
//  public static void main(String[] args) {
//    RecentCounter recentCounter = new RecentCounter();
//    assertEquals(1, recentCounter.ping(1));
//    assertEquals(2, recentCounter.ping(100));
//    assertEquals(3, recentCounter.ping(3001));
//    assertEquals(3, recentCounter.ping(3002));
//  }
//
//  /**
//   * Your RecentCounter object will be instantiated and called as such:
//   * RecentCounter obj = new RecentCounter();
//   * int param_1 = obj.ping(t);
//   */
//  class RecentCounter {
//    private final Queue<Integer> timeWindow;
//
//    public RecentCounter() {
//      timeWindow = new LinkedList<>();
//    }
//
//    /**
//     * Approach: Queue <br>
//     * Time Complexity: O(1) <-> Worst case O(3000) <br>
//     * Space Complexity: O(1) <-> Worst case O(3000) <br>
//     */
//    public int ping(int t) {
//      while (!timeWindow.isEmpty() && timeWindow.peek() < t - 3000) {
//        timeWindow.poll();
//      }
//      timeWindow.offer(t);
//      return timeWindow.size();
//    }
//  }
//}
