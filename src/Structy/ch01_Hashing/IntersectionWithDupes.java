package Structy.ch01_Hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/premium/intersection-with-dupes">Intersection With Dupes</a>
 */
public class IntersectionWithDupes {

  public static void main(String[] args) {
    assertTrue(List.of("b", "b").containsAll(
        intersectionWithDupes(List.of("a", "b", "c", "b"), List.of("x", "y", "b", "b"))));

    assertTrue(List.of("m", "s", "s").containsAll(
        intersectionWithDupes(
            List.of("q", "b", "m", "s", "s", "s"),
            List.of("s", "m", "s"))));

    assertTrue(List.of("r").containsAll(
        intersectionWithDupes(
            List.of("p", "r", "r", "r"),
            List.of("r"))));

    assertTrue(List.of("r").containsAll(
        intersectionWithDupes(
            List.of("r"),
            List.of("p", "r", "r", "r"))));

    assertTrue(List.of().containsAll(
        intersectionWithDupes(
            List.of("t", "v", "u"),
            List.of("g", "e", "d", "f"))));

    assertTrue(List.of("a", "a", "a", "a").containsAll(
        intersectionWithDupes(
            List.of("a", "a", "a", "a", "a", "a"),
            List.of("a", "a", "a", "a"))));
  }

  /**
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(n + m) <br>
   */
  public static List<String> intersectionWithDupes(List<String> listA, List<String> listB) {
    Map<String, Integer> counterA = countElements(listA);
    Map<String, Integer> counterB = countElements(listB);
    List<String> result = new ArrayList<>();
    for (String s : counterA.keySet()) {
      if (counterB.containsKey(s)) {
        for (int i = 0; i < Math.min(counterA.get(s), counterB.get(s)); i++) {
          result.add(s);
        }
      }
    }
    return result;
  }

  private static Map<String, Integer> countElements(List<String> strList) {
    Map<String, Integer> strCounter = new HashMap<>();
    for (String s : strList) {
      strCounter.put(s, strCounter.getOrDefault(s, 0) + 1);
    }
    return strCounter;
  }
}
