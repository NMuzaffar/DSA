//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.*;
//
///**
// * <a href="https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/">2294. Partition Array Such That Maximum Difference Is K</a>
// */
//public class Problem2294 {
//
//  public static void main(String[] args) {
//    assertEquals(2, partitionArray(new int[] {3, 6, 1, 2, 5}, 2));
//    assertEquals(2, partitionArray(new int[] {1, 2, 3}, 1));
//    assertEquals(3, partitionArray(new int[] {2, 2, 4, 5}, 0));
//  }
//
//  /**
//   * Approach: Sort + Greedy <br>
//   * Time Complexity: O(n * log(n)) <br>
//   * Space Complexity: O(log(n)) <br>
//   */
//  public static int partitionArray(int[] nums, int k) {
//    Arrays.sort(nums);
//    int partitionsCount = 1;
//    int start = nums[0];
//    for (int num : nums) {
//      if (num > start + k) {
//        partitionsCount++;
//        start = num;
//      }
//    }
//    return partitionsCount;
//  }
//}
