package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/">2342. Max Sum of a Pair With Equal Sum of Digits</a>
 */
public class Problem2342 {

  public static void main(String[] args) {
    assertEquals(54, maximumSum(new int[] {18,43,36,13,7}));
    assertEquals(-1, maximumSum(new int[] {10,12,19,14}));
    assertEquals(4, maximumSum(new int[] {9,2,2,5}));
    assertEquals(872, maximumSum(new int[] {279,169,463,252,94,455,423,315,288,64,494,337,409,283,283,477,248,8,89,166,188,186,128}));
  }

  /**
   * Approach: Hash Map (One Pass) <br>
   * Time Complexity: O(n * k) <br>
   * Space Complexity: O(n) <br>
   */
  public static int maximumSum(int[] nums) {
    int answer = -1;
    Map<Integer, Integer> digitSumMap = new HashMap<>();
    for (int num : nums) { // O(n)
      int digitSum = getDigitSum(num); // O(k)
      if (digitSumMap.containsKey(digitSum)) {
        answer = Math.max(answer, num + digitSumMap.get(digitSum));
      }
      digitSumMap.put(digitSum, Math.max(digitSumMap.getOrDefault(digitSum, 0), num));
    }
    return answer;
  }

//  /**
//   * Approach: Hash Map (Sorting) <br>
//   * Time Complexity: O(n * (k + m * log(m))) <br>
//   * Space Complexity: O(n * m) <br>
//   */
//  public static int maximumSum(int[] nums) {
//    Map<Integer, List<Integer>> digitSumMap = new HashMap<>();
//    for (int num : nums) { // O(n)
//      int digitSum = getDigitSum(num); // O(k)
//      digitSumMap.computeIfAbsent(digitSum, k -> new ArrayList<>()).add(num);
//    }
//    int answer = -1;
//    for (int digitSumKey : digitSumMap.keySet()) { // O(n)
//      List<Integer> numPairs = digitSumMap.get(digitSumKey);
//      if (numPairs.size() > 1) {
//        Collections.sort(numPairs, Collections.reverseOrder()); // O(m * log(m))
//        answer = Math.max(answer, numPairs.get(0) + numPairs.get(1));
//      }
//    }
//    return answer;
//  }

  /**
   * Time Complexity: O(k) <br>
   * Space Complexity: O(1) <br>
   */
  private static int getDigitSum(int num) {
    int digitSum = 0;
    while (num > 0) {
      digitSum += num % 10;
      num /= 10;
    }
    return digitSum;
  }
}
