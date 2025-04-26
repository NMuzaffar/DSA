package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">1248. Count Number of Nice Subarrays</a>
 */
public class Problem1248 {

  public static void main(String[] args) {
    assertEquals(2, numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
    assertEquals(0, numberOfSubarrays(new int[] {2,4,6}, 1));
    assertEquals(16, numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int numberOfSubarrays(int[] nums, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, 1);

    int answer = 0;
    int currOdd = 0;
    for (int num : nums) {
      currOdd += num % 2;
      answer += counts.getOrDefault(currOdd - k, 0);
      counts.put(currOdd, counts.getOrDefault(currOdd, 0) + 1);
    }
    return answer;
  }

//  /**
//   * Approach: Cumulative Sum -> Time Limit Exceeded <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int numberOfSubarrays(int[] nums, int k) {
//    int answer = 0;
//    for (int left = 0; left < nums.length; left++) {
//      int currOdd = 0;
//      for (int right = left; right < nums.length; right++) {
//        currOdd += nums[right] % 2;
//        if (currOdd == k) {
//          answer++;
//        }
//      }
//    }
//    return answer;
//  }
}
