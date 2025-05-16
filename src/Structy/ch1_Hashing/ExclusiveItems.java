package Structy.ch1_Hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/premium/exclusive-items">Exclusive Items</a>
 */
public class ExclusiveItems {

  public static void main(String[] args) {
    assertEquals(Set.of(4, 1, 3, 9, 10), new HashSet<>(exclusiveItems(List.of(4, 2, 1, 6), List.of(3, 6, 9, 2, 10))));
    assertEquals(Set.of(6), new HashSet<>(exclusiveItems(List.of(2, 4, 6), List.of(4, 2))));
    assertEquals(Set.of(6), new HashSet<>(exclusiveItems(List.of(4, 2, 1), List.of(1, 2, 4, 6))));
    assertEquals(Set.of(0, 1, 2, 10, 11), new HashSet<>(exclusiveItems(List.of(0, 1, 2), List.of(10, 11))));
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    for (int i = 0; i < 60000; i += 1) {
      a.add(i);
      b.add(i);
    }
    assertEquals(Collections.emptySet(), new HashSet<>(exclusiveItems(a, b)));
  }

  /**
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(n + m) <br>
   */
  public static List<Integer> exclusiveItems(List<Integer> a, List<Integer> b) {
    List<Integer> result = new ArrayList<>();
    Set<Integer> setA = new HashSet<>(a);
    Set<Integer> setB = new HashSet<>(b);
    for (int num : setA) {
      if (!setB.contains(num)) {
        result.add(num);
      }
    }
    for (int num : setB) {
      if (!setA.contains(num)) {
        result.add(num);
      }
    }
    return result;
  }
}
