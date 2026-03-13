//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
///**
// * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">17. Letter
// * Combinations of a Phone Number</a>
// */
//public class Problem17 {
//
//  public static void main(String[] args) {
//    //      List<List<Integer>> actual = List.of(List.of(1,2,3), List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1));
//    //      assertTrue(subsets(new int[] {1,2,3}).contains(actual));
//    //
//    //      actual = List.of(List.of(0,1), List.of(1,0));
//    //      assertTrue(subsets(new int[] {0,1}).contains(actual));
//    //
//    //      actual = List.of(List.of(1));
//    //      assertTrue(subsets(new int[] {1}).contains(actual));
//  }
//
//  /**
//   * Approach: Backtracking <br>
//   * Time Complexity: O() <br>
//   * Space Complexity: O() <br>
//   */
//  public static List<String> letterCombinations(String digits) {
//    if (digits.isEmpty()) {
//      return Collections.emptyList();
//    }
//    char[] digitsArr = digits.toCharArray();
//    List<String> result = new ArrayList<>();
//    backtrack(new StringBuilder(), result, digitsArr, 0);
//    return result;
//  }
//
//  private static void backtrack(StringBuilder sb, List<String> result, char[] digitsArr, int currIndex) {
//    if (sb.length() == digitsArr.length) {
//      result.add(sb.toString());
//      return;
//    }
//    if (currIndex < digitsArr.length) {
//      for (char letter : digitLetterMapping.get(digitsArr[currIndex])) {
//        sb.append(letter);
//        backtrack(sb, result, digitsArr, currIndex + 1);
//        sb.deleteCharAt(sb.length() - 1);
//      }
//    }
//  }
//
//  private static final Map<Character, List<Character>> digitLetterMapping =
//      Map.of(
//          '2', List.of('a', 'b', 'c'),
//          '3', List.of('d', 'e', 'f'),
//          '4', List.of('g', 'h', 'i'),
//          '5', List.of('j', 'k', 'l'),
//          '6', List.of('m', 'n', 'o'),
//          '7', List.of('p', 'q', 'r', 's'),
//          '8', List.of('t', 'u', 'v'),
//          '9', List.of('w', 'x', 'y', 'z'));
//}
