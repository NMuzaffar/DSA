package Structy.ch02_Recursion_Beginner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

/**
 * <a href="https://structy.net/problems/sum-numbers-recursive">Sum Numbers Recursive</a>
 */
public class SumNumbersRecursive {

  public static void main(String[] args) {
    assertEquals(26, sumNumbersRecursive(List.of(5, 2, 9, 10)));
    assertEquals(1, sumNumbersRecursive(List.of(1, -1, 1, -1, 1, -1, 1)));
    assertEquals(0, sumNumbersRecursive(List.of()));
    assertEquals(1001, sumNumbersRecursive(List.of(1000, 0, 0, 0, 0, 0, 1)));
    assertEquals(777, sumNumbersRecursive(List.of(700, 70, 7)));
    assertEquals(-55, sumNumbersRecursive(List.of(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1)));
    assertEquals(0, sumNumbersRecursive(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
    assertEquals(137174205, sumNumbersRecursive(List.of(123456789, 12345678, 1234567, 123456, 12345, 1234, 123, 12, 1, 0)));
  }

  /**
   * Time Complexity: O(n^2) <br>
   * Space Complexity: O(n^2) <br>
   */
  public static int sumNumbersRecursive(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }
    return numbers.get(0) + sumNumbersRecursive(numbers.subList(1, numbers.size()));
  }
}
