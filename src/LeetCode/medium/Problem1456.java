//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Set;
//
///**
// * <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. Maximum Number of Vowels in a Substring of Given Length</a>
// */
//public class Problem1456 {
//
//  public static void main(String[] args) {
//    assertEquals(3, maxVowels("abciiidef", 3));
//    assertEquals(2, maxVowels("aeiou", 2));
//    assertEquals(2, maxVowels("leetcode", 3));
//  }
//
//  /**
//   * Approach: Sliding Window <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static int maxVowels(String s, int k) {
//    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
//    int currVowelCount = 0;
//    for (int i = 0; i < k; i++) {
//      currVowelCount += vowels.contains(s.charAt(i)) ? 1 : 0;
//    }
//
//    int answer = currVowelCount;
//    for (int i = k; i < s.length(); i++) {
//      currVowelCount += vowels.contains(s.charAt(i)) ? 1 : 0;
//      currVowelCount -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
//      answer = Math.max(answer, currVowelCount);
//    }
//    return answer;
//  }
//}
