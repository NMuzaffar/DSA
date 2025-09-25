package Structy.ch02_Recursion_Beginner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

/**
 * <a href="https://structy.net/problems/premium/sum-of-lengths">Sum Of Lengths</a>
 */
public class SumOfLengths {

  public static void main(String[] args) {
    assertEquals(13, sumOfLengths(List.of("goat", "cat", "purple")));
    assertEquals(18, sumOfLengths(List.of("bike", "at", "pencils", "phone")));
    assertEquals(0, sumOfLengths(List.of()));
    assertEquals(15, sumOfLengths(List.of("", " ", "  ", "   ", "    ", "     ")));
    assertEquals(14, sumOfLengths(List.of("0", "313", "1234567890")));
  }

  /**
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static int sumOfLengths(List<String> strings) {
    if (strings.isEmpty()) {
      return 0;
    }
    return strings.get(0).length() + sumOfLengths(strings.subList(1, strings.size()));
  }
}
