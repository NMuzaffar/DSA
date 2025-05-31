//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <a href="https://leetcode.com/problems/contiguous-array/">525. Contiguous Array</a>
// */
//public class Problem525 {
//
//  public static void main(String[] args) {
//    assertEquals(2, findMaxLength(new int[] {0,1}));
//    assertEquals(2, findMaxLength(new int[] {0,1,0}));
//    assertEquals(6, findMaxLength(new int[] {0,1,1,1,1,1,0,0,0}));
//    assertEquals(4, findMaxLength(new int[] {0,1,0,1}));
//    assertEquals(4, findMaxLength(new int[]{0,1,1,0,1,1,1,0}));
//  }
//
//  /**
//   * Approach: Hash Map <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int findMaxLength(int[] nums) {
//    Map<Integer, Integer> numsIndexMap = new HashMap<>();
//    numsIndexMap.put(0, 0);
//
//    int answer = 0;
//    int sum = 0;
//    for (int right = 0; right < nums.length; right++) {
//      sum += nums[right] == 1 ? 1 : -1; // 1 -> +1, 0 -> -1
//      if (numsIndexMap.containsKey(sum)) {
//        int left = numsIndexMap.get(sum);
//        answer = Math.max(answer, right - left + 1);
//      } else {
//        numsIndexMap.put(sum, right + 1);
//      }
//    }
//    return answer;
//  }
//
////  /**
////   * Approach: Brute Force -> Time Limit Exceeded <br>
////   * Time Complexity: O(n^2) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int findMaxLength(int[] nums) {
////    int answer = 0;
////    for (int left = 0; left < nums.length; left++) {
////      int zeroes = 0;
////      int ones = 0;
////      for (int right = left; right < nums.length; right++) {
////        if (nums[right] == 0) {
////          zeroes++;
////        } else {
////          ones++;
////        }
////        if (zeroes == ones) {
////          answer = Math.max(answer, right - left + 1);
////        }
////      }
////    }
////    return answer;
////  }
//}
