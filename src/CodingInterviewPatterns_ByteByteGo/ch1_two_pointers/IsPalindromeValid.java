//package CodingInterviewPatterns_ByteByteGo.ch1_two_pointers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/largest-container">Is Palindrome Valid</a>
// */
//public class IsPalindromeValid {
//
//  public static void main(String[] args) {
//    assertEquals(true, isPalindromeValid("a dog! a panic in a pagoda."));
//    assertEquals(false, isPalindromeValid("abc123"));
//  }
//
//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean isPalindromeValid(String s) {
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
