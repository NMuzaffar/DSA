package Structy.ch1_Hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/pair-sum">Pair Sum</a>
 */
public class PairSum {

  public static void main(String[] args) {
    assertEquals(List.of(0, 2), pairSum(List.of(3, 2, 5, 4, 1), 8));
    assertEquals(List.of(0, 5), pairSum(List.of(4, 7, 9, 2, 5, 1), 5));
    assertEquals(List.of(3, 5), pairSum(List.of(4, 7, 9, 2, 5, 1), 3));
    assertEquals(List.of(1, 2), pairSum(List.of(1, 6, 7, 2), 13));
    assertEquals(List.of(0, 1), pairSum(List.of(9, 9), 18));
    assertEquals(List.of(1, 3), pairSum(List.of(6, 4, 2, 8 ), 12));
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 25000; i += 1) {
      numbers.add(i);
    }
    assertEquals(List.of(24998, 24999), pairSum(numbers, 49999));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> pairSum(List<Integer> numbers, int target) {
    Map<Integer, Integer> numsIndexMap = new HashMap<>();
    for (int i = 0; i < numbers.size(); i++) {
      int num = numbers.get(i);
      int complement = target - num;
      if (numsIndexMap.containsKey(complement)) {
        return List.of(numsIndexMap.get(complement), i);
      }
      numsIndexMap.put(num, i);
    }
    return Collections.emptyList();
  }
}
