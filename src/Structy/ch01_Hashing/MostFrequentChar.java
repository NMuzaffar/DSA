package Structy.ch01_Hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://structy.net/problems/most-frequent-char">Most Frequent Char</a>
 */
public class MostFrequentChar {

  public static void main(String[] args) {
    assertEquals('e', mostFrequentChar("bookeeper"));
    assertEquals('d', mostFrequentChar("david"));
    assertEquals('b', mostFrequentChar("abby"));
    assertEquals('i', mostFrequentChar("mississippi"));
    assertEquals('o', mostFrequentChar("potato"));
    assertEquals('e', mostFrequentChar("eleventennine"));
    assertEquals('r', mostFrequentChar("riverbed"));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static char mostFrequentChar(String s) {
    Map<Character, Integer> charCounter = new HashMap<>();
    for (char c : s.toCharArray()) {
      charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
    }
    char mostFrequent = '\0'; // null
    for (char c : s.toCharArray()) {
      if (mostFrequent == '\0' || charCounter.get(c) > charCounter.get(mostFrequent)) {
        mostFrequent = c;
      }
    }
    return mostFrequent;
  }
}
