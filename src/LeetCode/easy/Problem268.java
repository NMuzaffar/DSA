//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
// */
//public class Problem268 {
//
//  public static void main(String[] args) {
//    assertEquals(2, missingNumber(new int[] {3,0,1}));
//    assertEquals(2, missingNumber(new int[] {0,1}));
//    assertEquals(8, missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
//  }
//
//  /**
//   * Approach: Addition Approach (Gauss' Formula) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int missingNumber(int[] nums) {
//    int n = nums.length;
//    int expectedSum = n * (n + 1) / 2;
//    int actualSum = 0;
//    for (int num : nums) {
//      actualSum += num;
//    }
//    return expectedSum - actualSum;
//  }
//
////  /**
////   * Approach: Hash Set <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static int missingNumber(int[] nums) {
////    Set<Integer> numSet = new HashSet<>();
////    for (int num : nums) {
////      numSet.add(num);
////    }
////    for (int i = 0; i <= nums.length; i++) {
////      if (!numSet.contains(i)) {
////        return i;
////      }
////    }
////    return -1;
////  }
////
////  /**
////   * Approach: Sorting <br>
////   * Time Complexity: O(n * log(n)) <br>
////   * Space Complexity: O(log(n)) <-> Quicksort Algorithm in Java <br>
////   */
////  public static int missingNumber(int[] nums) {
////    Arrays.sort(nums);
////    int n = nums.length;
////    for (int i = 0; i < n; i++) {
////      if (nums[i] != i) {
////        return i;
////      }
////    }
////    return n;
////  }
//}
