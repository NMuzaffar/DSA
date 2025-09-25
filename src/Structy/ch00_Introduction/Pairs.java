package Structy.ch00_Introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://structy.net/problems/pairs">Pairs</a>
 */
public class Pairs {

  public static void main(String[] args) {
    assertEquals(
        new ArrayList<>(List.of(List.of("a", "b"), List.of("a", "c"), List.of("b", "c"))),
        pairs(List.of("a", "b", "c")));

    assertEquals(
        new ArrayList<>(
            List.of(
                List.of("a", "b"),
                List.of("a", "c"),
                List.of("a", "d"),
                List.of("b", "c"),
                List.of("b", "d"),
                List.of("c", "d"))),
        pairs(List.of("a", "b", "c", "d")));

    assertEquals(
        new ArrayList<>(
            List.of(
                List.of("cherry", "cranberry"),
                List.of("cherry", "banana"),
                List.of("cherry", "blueberry"),
                List.of("cherry", "lime"),
                List.of("cherry", "papaya"),
                List.of("cranberry", "banana"),
                List.of("cranberry", "blueberry"),
                List.of("cranberry", "lime"),
                List.of("cranberry", "papaya"),
                List.of("banana", "blueberry"),
                List.of("banana", "lime"),
                List.of("banana", "papaya"),
                List.of("blueberry", "lime"),
                List.of("blueberry", "papaya"),
                List.of("lime", "papaya"))),
        pairs(List.of("cherry", "cranberry", "banana", "blueberry", "lime", "papaya")));
  }

  /**
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static List<List<String>> pairs(List<String> elements) {
    List<List<String>> answer = new ArrayList<>();
    for (int i = 0; i < elements.size(); i++) {
      for (int j = i + 1; j < elements.size(); j++) {
        answer.add(List.of(elements.get(i), elements.get(j)));
      }
    }
    return answer;
  }
}
