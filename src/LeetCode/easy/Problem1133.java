//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
///**
// * <a href="https://leetcode.com/problems/largest-unique-number/">1133. Largest Unique Number</a>
// */
//public class Problem1133 {
//
//  public static void main(String[] args) {
//    assertEquals(8, largestUniqueNumber(new int[] {5,7,3,9,4,9,8,3,1}));
//    assertEquals(-1, largestUniqueNumber(new int[] {9,9,8,8}));
//  }
//
//  /**
//   * Approach: Hash Map <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int largestUniqueNumber(int[] nums) {
//    Map<Integer, Integer> numsFrequencies = new HashMap<>();
//    for (int num : nums) {
//      numsFrequencies.put(num, numsFrequencies.getOrDefault(num, 0) + 1);
//    }
//    int largestUnique = -1;
//    for (int num : numsFrequencies.keySet()) {
//      if (numsFrequencies.get(num) == 1 && num > largestUnique) {
//        largestUnique = num;
//      }
//    }
//    return largestUnique;
//  }
//
////  /**
////   * Approach: Sorted Map <br>
////   * Time Complexity: O(n * log(n)) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static int largestUniqueNumber(int[] nums) {
////    TreeMap<Integer, Integer> numsFrequencies = new TreeMap<>();
////    for (int num : nums) {
////      numsFrequencies.put(num, numsFrequencies.getOrDefault(num, 0) + 1); // Insertion log(k) (Worst case log(n))
////    }
////    int largestUnique = -1;
////    for (int num : numsFrequencies.descendingKeySet()) { // O(n * log(n))
////      if (numsFrequencies.get(num) == 1) {
////        largestUnique = num;
////        break;
////      }
////    }
////    return largestUnique;
////  }
//}
