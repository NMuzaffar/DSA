//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * <a href="https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/">2260. Minimum Consecutive Cards to Pick Up</a>
// */
//public class Problem2260 {
//
//  public static void main(String[] args) {
//    assertEquals(4, minimumCardPickup(new int[] {3,4,2,3,4,7}));
//    assertEquals(-1, minimumCardPickup(new int[] {1,0,5,3}));
//  }
//
//  /**
//   * Approach: Hash Map (One Pass) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int minimumCardPickup(int[] cards) {
//    int answer = Integer.MAX_VALUE;
//    Map<Integer, Integer> lastCardOccurrence = new HashMap<>();
//    for (int i = 0; i < cards.length; i++) {
//      if (lastCardOccurrence.containsKey(cards[i])) {
//        answer = Math.min(answer, i - lastCardOccurrence.get(cards[i]) + 1);
//      }
//      lastCardOccurrence.put(cards[i], i);
//    }
//    return answer == Integer.MAX_VALUE ? -1 : answer;
//  }
//
////  /**
////   * Approach: Hash Map (Two Pass) <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static int minimumCardPickup(int[] cards) {
////    Map<Integer, List<Integer>> cardOccurrences = new HashMap<>();
////    for (int i = 0; i < cards.length; i++) {
////      cardOccurrences.computeIfAbsent(cards[i], k -> new ArrayList<>()).add(i);
////    }
////    int answer = Integer.MAX_VALUE;
////    for (List<Integer> cardFrequencies : cardOccurrences.values()) {
////      if (cardFrequencies.size() > 1) {
////        for (int i = 1; i < cardFrequencies.size(); i++) {
////          answer = Math.min(answer, cardFrequencies.get(i) - cardFrequencies.get(i - 1) + 1);
////        }
////      }
////    }
////    return answer == Integer.MAX_VALUE ? -1 : answer;
////  }
//}
