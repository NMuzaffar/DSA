package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">560. Subarray Sum Equals K</a>
 */
public class Problem560 {

  public static void main(String[] args) {
    assertEquals(2, subarraySum(new int[] {1,1,1}, 2));
    assertEquals(2, subarraySum(new int[] {1,2,3}, 3));
    assertEquals(1, subarraySum(new int[] {0,1,2,3,4}, 5));
  }

  /**
   * Approach: Hash Map <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, 1);

    int answer = 0;
    int curr = 0;
    for (int num : nums) {
      curr += num;
      answer += counts.getOrDefault(curr - k, 0);
      counts.put(curr, counts.getOrDefault(curr, 0) + 1);
    }
    return answer;
  }

//  /**
//   * Approach: Cumulative Sum (Space Optimal) <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int subarraySum(int[] nums, int k) {
//    int answer = 0;
//    for (int start = 0; start < nums.length; start++) {
//      int sum = 0;
//      for (int end = start; end < nums.length; end++) {
//        sum += nums[end];
//        if (sum == k) {
//          answer++;
//        }
//      }
//    }
//    return answer;
//  }
//
//  /**
//   * Approach: Cumulative Sum <br>
//   * Time Complexity: O(n^2) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int subarraySum(int[] nums, int k) {
//    int n = nums.length;
//    int[] prefix = new int[n];
//    prefix[0] = nums[0];
//    for (int i = 1; i < n; i++) {
//      prefix[i] = prefix[i - 1] + nums[i];
//    }
//
//    int answer = 0;
//    for (int start = 0; start < nums.length; start++) {
//      for (int end = start; end < nums.length; end++) {
//        int subarrSum = prefix[end] - prefix[start] + nums[start];
//        if (subarrSum == k) {
//          answer++;
//
//        }
//      }
//    }
//    return answer;
//  }
//
//  /**
//   * Approach: Brute Force -> Time Limit Exceeded <br>
//   * Time Complexity: O(n^3) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int subarraySum(int[] nums, int k) {
//    int answer = 0;
//    for (int start = 0; start < nums.length; start++) {
//      for (int end = start + 1; end <= nums.length; end++) {
//        int sum = 0;
//        for (int i = start; i < end; i++) {
//          sum += nums[i];
//        }
//        if (sum == k) {
//          answer++;
//        }
//      }
//    }
//    return answer;
//  }
}
