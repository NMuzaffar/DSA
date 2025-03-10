//package CodingInterviewPatterns_ByteByteGo.ch1_two_pointers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/largest-container">Largest Container</a>
// */
//public class LargestContaier {
//
//  public static void main(String[] args) {
//    assertEquals(24, largestContainer(new int[] {2, 7, 8, 3, 7, 6}));
//  }
//
//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int largestContainer(int[] height) {
//    int n = height.length;
//    int answer = 0;
//
//    for (int i = 0; i < n; i++) {
//      for (int j = i + 1; j < n; j++) {
//        int x = Math.abs(j - i);
//        int y = Math.min(height[i], height[j]);
//        result = Math.max(result, x * y);
//      }
//    }
//
//    return answer;
//  }
//}
