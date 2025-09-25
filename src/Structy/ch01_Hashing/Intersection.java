package Structy.ch01_Hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://structy.net/problems/intersection">Intersection</a>
 */
public class Intersection {

  public static void main(String[] args) {
    assertEquals(Set.of(2, 6), new HashSet<>(intersection(List.of(4, 2, 1, 6), List.of(3, 6, 9, 2, 10))));
    assertEquals(Set.of(2, 4), new HashSet<>(intersection(List.of(2, 4, 6), List.of(4, 2))));
    assertEquals(Set.of(1, 2, 4), new HashSet<>(intersection(List.of(4, 2, 1), List.of(1, 2, 4, 6))));
    assertEquals(Set.of(), new HashSet<>(intersection(List.of(0, 1, 2), List.of(10, 11))));
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    for (int i = 0; i < 60000; i += 1) {
      a.add(i);
      b.add(i);
    }
    assertEquals(IntStream.range(0, 60000).boxed().collect(Collectors.toSet()), new HashSet<>(intersection(a, b)));
  }

  /**
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> intersection(List<Integer> listA, List<Integer> listB) {
    List<Integer> result = new ArrayList<>();
    Set<Integer> setA = new HashSet<>(listA);
    for (int num : listB) {
      if (setA.contains(num)) {
        result.add(num);
      }
    }
    return result;
  }
}
