package Structy.ch01_Hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/pair-product">Pair Product</a>
 */
public class PairProduct  {

  public static void main(String[] args) {
    assertEquals(List.of(1, 3), pairProduct(List.of(3, 2, 5, 4, 1), 8));
    assertEquals(List.of(1, 2), pairProduct(List.of(3, 2, 5, 4, 1), 10));
    assertEquals(List.of(4, 5), pairProduct(List.of(4, 7, 9, 2, 5, 1), 5));
    assertEquals(List.of(1, 4), pairProduct(List.of(4, 7, 9, 2, 5, 1), 35));
    assertEquals(List.of(1, 2), pairProduct(List.of(3, 2, 5, 4, 1), 10));
    assertEquals(List.of(2, 3), pairProduct(List.of(4, 6, 8, 2), 16));
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 25000; i += 1) {
      numbers.add(i);
    }
    assertEquals(List.of(24998, 24999), pairProduct(numbers, 624975000));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> pairProduct(List<Integer> numbers, int target) {
    Map<Double, Integer> numsIndexMap = new HashMap<>();
    for (int i = 0; i < numbers.size(); i++) {
      int num = numbers.get(i);
      double complement = (double) target / num;
      if (numsIndexMap.containsKey(complement)) {
        return List.of(numsIndexMap.get(complement), i);
      }
      numsIndexMap.put((double) num, i);
    }
    return Collections.emptyList();
  }
}
