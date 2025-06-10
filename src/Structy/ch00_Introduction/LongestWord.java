package Structy.ch00_Introduction;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/longest-word">Longest Word</a>
 */
public class LongestWord {

  public static void main(String[] args) {
    assertEquals("wonderful", longestWord("what a wonderful world"));
    assertEquals("nice", longestWord("have a nice day"));
    assertEquals("jumped", longestWord("the quick brown fox jumped over the lazy dog"));
    assertEquals("ham", longestWord("who did eat the ham"));
    assertEquals("potato", longestWord("potato"));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String longestWord(String sentence) {
    String[] words = sentence.split(" ");
    String longest = "";
    for (String word : words) {
      if (word.length() >= longest.length()) {
        longest = word;
      }
    }
    return longest;
  }
}
