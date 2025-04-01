package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram/">1832. Check if the Sentence Is Pangram</a>
 */
public class Problem1832 {

  public static void main(String[] args) {
    assertTrue(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    assertFalse(checkIfPangram("leetcode"));
  }

  /**
   * Approach: Hash Set <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean checkIfPangram(String sentence) {
    Set<Character> seen = new HashSet<>();
    for (char currChar : sentence.toCharArray()) {
      seen.add(currChar);
    }
    return seen.size() == 26;
  }

//  /**
//   * Approach: Use Array as Counter <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static boolean checkIfPangram(String sentence) {
//    boolean[] seen = new boolean[26];
//    for (char currChar : sentence.toCharArray()) {
//      seen[currChar - 'a'] = true;
//    }
//    for (boolean status : seen) {
//      if (!status)
//        return false;
//    }
//    return true;
//  }
//
//  /**
//   * Approach: Find letters one by one <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static boolean checkIfPangram(String sentence) {
//    for (int i = 0; i < 26; i++) {
//      char currChar = (char) ('a' + i);
//      if (sentence.indexOf(currChar) == -1) {
//        return false;
//      }
//    }
//    return true;
//  }
}
