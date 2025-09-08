//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.*;
//
///**
// * <a href="https://leetcode.com/problems/logger-rate-limiter/">359. Logger Rate Limiter</a>
// */
//public class Problem379 {
//
//  public static void main(String[] args) {
//    Logger logger = new Logger();
//    assertTrue(logger.shouldPrintMessage(1, "foo"));
//    assertTrue(logger.shouldPrintMessage(2, "bar"));
//    assertFalse(logger.shouldPrintMessage(3, "foo"));
//    assertFalse(logger.shouldPrintMessage(8, "bar"));
//    assertFalse(logger.shouldPrintMessage(10, "foo"));
//    assertTrue(logger.shouldPrintMessage(11, "foo"));
//  }
//
//  /**
//   * Your Logger object will be instantiated and called as such:
//   * Logger obj = new Logger();
//   * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
//   */
//  class Logger {
//    private final Map<String, Integer> messageTimestamps;
//
//    public Logger() {
//      messageTimestamps = new HashMap<>();
//    }
//
//    /**
//     * Approach: Hash Map <br>
//     * Time Complexity: O(1) <br>
//     * Space Complexity: O(M) <-> M is the size of all incoming messages <br>
//     */
//    public boolean shouldPrintMessage(int timestamp, String message) {
//      int nextAllowedTimestamp = messageTimestamps.getOrDefault(message, 0);
//      if (timestamp < nextAllowedTimestamp) {
//        return false;
//      }
//      messageTimestamps.put(message, timestamp + 10);
//      return true;
//    }
//  }
//}
