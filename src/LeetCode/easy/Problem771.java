//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * <a href="https://leetcode.com/problems/jewels-and-stones/">771. Jewels and Stones</a>
// */
//public class Problem771 {
//
//  public static void main(String[] args) {
//    assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
//    assertEquals(0, numJewelsInStones("z", "ZZ"));
//  }
//
//  /**
//   * Approach: Hash Set <br>
//   * Time Complexity: O(n + m) <br>
//   * Space Complexity: O(m) <br>
//   */
//  public static int numJewelsInStones(String jewels, String stones) {
//    Set<Character> jewelsSet = new HashSet<>();
//    for (char j : jewels.toCharArray()) {
//      jewelsSet.add(j);
//    }
//    int jewelsCount = 0;
//    for (char s : stones.toCharArray()) {
//      if (jewelsSet.contains(s)) {
//        jewelsCount++;
//      }
//    }
//    return jewelsCount;
//  }
//
////  /**
////   * Approach: Brute Force <br>
////   * Time Complexity: O(n * m) <br>
////   * Space Complexity: O(1) <br>
////   */
////  public static int numJewelsInStones(String jewels, String stones) {
////    int jewelsCount = 0;
////    for (char s : stones.toCharArray()) {
////      for (char j : jewels.toCharArray()) {
////        if (s == j) {
////          jewelsCount++;
////          break;
////        }
////      }
////    }
////    return jewelsCount;
////  }
//}
