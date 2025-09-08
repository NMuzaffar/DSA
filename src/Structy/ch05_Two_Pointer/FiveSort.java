package Structy.ch05_Two_Pointer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://structy.net/problems/premium/five-sort">Five Sort</a>
 */
public class FiveSort {

  public static void main(String[] args) {
    assertEquals(new ArrayList<>(List.of(0, 5)), fiveSort(new ArrayList<>(List.of(5, 0))));

    assertEquals(
        new ArrayList<>(List.of(12, 7, 1, 12, 5, 5)),
        fiveSort(new ArrayList<>(List.of(12, 5, 1, 5, 12, 7))));

    assertEquals(
        new ArrayList<>(List.of(2, 2, 10, 6, 1, 5, 5, 5, 5, 5)),
        fiveSort(new ArrayList<>(List.of(5, 2, 5, 6, 5, 1, 10, 2, 5, 5))));

    assertEquals(
        new ArrayList<>(List.of(4, 1, 1, 1, 5, 5, 5)),
        fiveSort(new ArrayList<>(List.of(5, 5, 5, 1, 1, 1, 4))));

    assertEquals(new ArrayList<>(
        List.of(6, 5, 5, 5, 5, 5, 5)),
        fiveSort(new ArrayList<>(List.of(5, 5, 6, 5, 5, 5, 5))));

    assertEquals(
        new ArrayList<>(List.of(4, 1, 2, 1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5)),
        fiveSort(new ArrayList<>(List.of(5, 1, 2, 5, 5, 3, 2, 5, 1, 5, 5, 5, 4, 5))));

    List<Integer> fives = new ArrayList<>(Collections.nCopies(20000, 5));
    List<Integer> fours = new ArrayList<>(Collections.nCopies(20000, 4));
    final List<Integer> actualArray = new ArrayList<>();
    actualArray.addAll(fives);
    actualArray.addAll(fours);
    final List<Integer> expectedArray = new ArrayList<>();
    actualArray.addAll(fours);
    actualArray.addAll(fives);
    assertEquals(expectedArray, fiveSort(actualArray));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static List<Integer> fiveSort(List<Integer> array) {
    int left = 0;
    int right = array.size() - 1;

    return array;
  }
}
