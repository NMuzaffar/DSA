//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>
// */
//public class Problem77 {
//
//  public static void main(String[] args) {
//    List<List<Integer>> actual =
//        List.of(
//            List.of(1, 2, 3),
//            List.of(1, 3, 2),
//            List.of(2, 1, 3),
//            List.of(2, 3, 1),
//            List.of(3, 1, 2),
//            List.of(3, 2, 1));
//    assertTrue(permute(new int[] {1, 2, 3}).contains(actual));
//
//    actual = List.of(List.of(0, 1), List.of(1, 0));
//    assertTrue(permute(new int[] {0, 1}).contains(actual));
//
//    actual = List.of(List.of(1));
//    assertTrue(permute(new int[] {1}).contains(actual));
//  }
//
//  /**
//   * Approach: Backtracking <br>
//   * Time Complexity: O() <br>
//   * Space Complexity: O() <br>
//   */
//  public static List<List<Integer>> permute(int[] nums) {
//    List<List<Integer>> result = new ArrayList<>();
//    backtrack(new ArrayList<>(), result, nums);
//    return result;
//  }
//
//  private static void backtrack(List<Integer> curr, List<List<Integer>> result, int[] nums) {}
//}
