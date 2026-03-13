//package Coding_Interview_Patterns_ByteByteGo.ch01_two_pointers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/largest-container">Largest Container</a>
// */
//public class LargestContainer {
//
//  public static void main(String[] args) {
//    assertEquals(24, largestContainer(new int[] {2, 7, 8, 3, 7, 6}));
//    assertEquals(0, largestContainer(new int[] {}));
//    assertEquals(0, largestContainer(new int[] {1}));
//    assertEquals(0, largestContainer(new int[] {0, 1, 0}));
//    assertEquals(9, largestContainer(new int[] {3, 3, 3, 3}));
//    assertEquals(2, largestContainer(new int[] {1, 2, 3}));
//    assertEquals(2, largestContainer(new int[] {3, 2, 1}));
//  }
//
//  /**
//   * Approach: Two Pointers (Inward Traversal) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int largestContainer(int[] heights) {
//    int maxWater = 0;
//    int left = 0;
//    int right = heights.length - 1;
//    while (left < right) {
//      int water = Math.min(heights[left], heights[right]) * (right - left);
//      maxWater = Math.max(maxWater, water);
//      if (heights[left] < heights[right]) {
//        left++;
//      } else if (heights[left] > heights[right]) {
//        right--;
//      } else {
//        left++;
//        right--;
//      }
//    }
//    return maxWater;
//  }
//
////  /**
////   * Approach: Brute Force <br>
////   * Time Complexity: O(n^2) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int largestContainer(int[] heights) {
////    int maxWater = 0;
////    int n = heights.length;
////    for (int i = 0; i < n; i++) {
////      for (int j = i + 1; j < n; j++) {
////        int water = Math.min(heights[i], heights[j]) * (j - i);
////        maxWater = Math.max(maxWater, water);
////      }
////    }
////    return maxWater;
////  }
//}
