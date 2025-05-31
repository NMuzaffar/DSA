//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * <a href="https://leetcode.com/problems/first-letter-to-appear-twice/">2351. First Letter to Appear Twice</a>
// */
//public class Problem2351 {
//
//  public static void main(String[] args) {
//    assertEquals('c', repeatedCharacter("abccbaacz"));
//    assertEquals('d', repeatedCharacter("abcdd"));
//  }
//
//  /**
//   * Approach: Hash Set <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) (OR O(m), m <-> the number of allowable characters in the input) <br>
//   */
//  public static char repeatedCharacter(String s) {
//    Set<Character> seen = new HashSet<>();
//    for (int i = 0; i < s.length(); i++) {
//      char c = s.charAt(i);
//      if (!seen.add(c)) {
//        return c;
//      }
//    }
//    throw new IllegalStateException("'s' should contain at least one letter that appears twice!");
//  }
//
////  /**
////   * Approach: Array List <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(1) (OR O(m), m <-> the number of allowable characters in the input) <br>
////   */
////  public static char repeatedCharacter(String s) {
////    int[] seen = new int[26];
////    for (int i = 0; i < s.length(); i++) {
////      char c = s.charAt(i);
////      if (seen['z' - c] == 1) {
////        return c;
////      }
////      seen['z' - c] = 1;
////    }
////    throw new IllegalStateException("'s' should contain at least one letter that appears twice!");
////  }
////
////  /**
////   * Approach: Brute Force <br>
////   * Time Complexity: O(n^2) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static char repeatedCharacter(String s) {
////    for (int i = 0; i < s.length(); i++) {
////      char c = s.charAt(i);
////      for (int j = 0; j < i; j++) {
////        if (s.charAt(j) == c) {
////          return c;
////        }
////      }
////    }
////    throw new IllegalStateException("'s' should contain at least one letter that appears twice!");
////  }
//}
