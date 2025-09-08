//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * <a href="https://leetcode.com/problems/moving-average-from-data-stream/">346. Moving Average from Data Stream</a>
// */
//public class Problem346 {
//
//  public static void main(String[] args) {
//    MovingAverage movingAverage = new MovingAverage(3);
//    assertEquals(1.0d, movingAverage.next(1), 0.001);
//    assertEquals(5.5d, movingAverage.next(10), 0.001);
//    assertEquals(4.66667d, movingAverage.next(3), 0.001);
//    assertEquals(6.0d, movingAverage.next(5), 0.001);
//  }
//
//  /**
//   * Your MovingAverage object will be instantiated and called as such:
//   * MovingAverage obj = new MovingAverage(size);
//   * double param_1 = obj.next(val);
//   */
//  class MovingAverage {
//    private final int maxWindowSize;
//    private final Queue<Integer> dataWindow;
//    private int sum = 0;
//
//    public MovingAverage(int size) {
//      this.maxWindowSize = size;
//      this.dataWindow = new LinkedList<>();
//    }
//
//    /**
//     * Approach: Queue <br>
//     * Time Complexity: O(1) <br>
//     * Space Complexity: O(K) <-> K is the length of the window <br>
//     */
//    public double next(int val) {
//      sum += val;
//      dataWindow.offer(val);
//      if (dataWindow.size() > maxWindowSize) {
//        sum -= dataWindow.poll();
//      }
//      return 1.0 * sum / dataWindow.size();
//    }
//  }
//}
