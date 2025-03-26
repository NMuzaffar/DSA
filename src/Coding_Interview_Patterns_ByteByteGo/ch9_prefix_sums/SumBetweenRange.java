//package CodingInterviewPatterns_ByteByteGo.ch9_prefix_sums;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://bytebytego.com/exercises/coding-patterns/prefix-sums/sum-between-range">Sum Between Range</a>
// */
//public class SumBetweenRange {
//
//  public static void main(String[] args) {
//    assertArrayEquals(new int[]{2, 4, 6}, sumRange(new int[]{3, -7, 6, 0, -2, 5}));
//  }
//
//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] sumRange(int[] s) {
//    int left = 0;
//    int right = s.length() - 1;
//
//    while (left < right) {
//      while (!Character.isAlphabetic(s.codePointAt(left))) {
//        left++;
//      }
//      while (!Character.isAlphabetic(s.codePointAt(right))) {
//        right--;
//      }
//      if (s.charAt(left) != s.charAt(right)) {
//        return false;
//      }
//      left++;
//      right--;
//    }
//
//    return true;
//  }
//}
