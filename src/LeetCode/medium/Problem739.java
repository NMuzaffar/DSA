//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
///**
// * <a href="https://leetcode.com/problems/daily-temperatures/">739. Daily Temperatures</a>
// */
//public class Problem739 {
//
//  public static void main(String[] args) {
//    assertArrayEquals(new int[] {1,1,4,2,1,1,0,0}, dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
//    assertArrayEquals(new int[] {1,1,1,0}, dailyTemperatures(new int[] {30,40,50,60}));
//    assertArrayEquals(new int[] {1,1,0}, dailyTemperatures(new int[] {30,60,90}));
//  }
//
//  /**
//   * Approach: Monotonic Stack (Decreasing <-> Non-increasing) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] dailyTemperatures1(int[] temperatures) {
//    int n = temperatures.length;
//    int[] answer = new int[n];
//    Deque<Integer> stack = new ArrayDeque<>();
//    for (int currDay = 0; currDay < n; currDay++) {
//      int currentTemp = temperatures[currDay];
//      while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
//        int prevDay = stack.pop();
//        answer[prevDay] = currDay - prevDay;
//      }
//      stack.push(currDay);
//    }
//    return answer;
//  }
//
//  /**
//   * Approach: Array (Optimized Space) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int[] dailyTemperatures(int[] temperatures) {
//    int n = temperatures.length;
//    int[] answer = new int[n];
//
//    return answer;
//  }
//}
