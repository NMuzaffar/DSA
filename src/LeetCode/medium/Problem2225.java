package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">2225. Find Players With Zero or One Losses</a>
 */
public class Problem2225 {

  public static void main(String[] args) {
    assertEquals(
        List.of(new ArrayList<>(List.of(1,2,10)), new ArrayList<>(List.of(4,5,7,8))),
        findWinners(new int[][] {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));

    assertEquals(
        List.of(new ArrayList<>(List.of(1,2,5,6)), new ArrayList<>(List.of())),
        findWinners(new int[][] {{2,3},{1,3},{5,4},{6,4}}));

    assertEquals(
        List.of(new ArrayList<>(List.of(1,2,3,4,6)), new ArrayList<>(List.of())),
        findWinners(new int[][] {{1,5},{2,5},{2,8},{2,9},{3,8},{4,7},{4,9},{5,7},{6,8}}));
  }

  /**
   * Approach: Array Counter <br>
   * Time Complexity: O(n + K) <-> K is the range of values in winner & loser <br>
   * Space Complexity: O(K) <br>
   */
  public static List<List<Integer>> findWinners(int[][] matches) {
    int[] lossesCount = new int[100001];
    Arrays.fill(lossesCount, -1);
    for (int[] match : matches) {
      int winner = match[0];
      int loser = match[1];
      if (lossesCount[winner] == -1) {
        lossesCount[winner] = 0;
      }
      if (lossesCount[loser] == -1) {
        lossesCount[loser] = 1;
      } else {
        lossesCount[loser]++;
      }
    }
    List<List<Integer>> answer = List.of(new ArrayList<>(), new ArrayList<>());
    for (int i = 1; i < 100001; i++) {
      if (lossesCount[i] == 0) {
        answer.get(0).add(i);
      } else if (lossesCount[i] == 1) {
        answer.get(1).add(i);
      }
    }
    return answer;
  }

//  /**
//   * Approach: Hash Map <br>
//   * Time Complexity: O(n * log(n)) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<List<Integer>> findWinners(int[][] matches) {
//    Map<Integer, Integer> lossesCount = new HashMap<>();
//    for (int[] match : matches) {
//      int winner = match[0];
//      int loser = match[1];
//      lossesCount.put(winner, lossesCount.getOrDefault(winner, 0));
//      lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
//    }
//    List<List<Integer>> answer = List.of(new ArrayList<>(), new ArrayList<>());
//    for (int player : lossesCount.keySet()) {
//      if (lossesCount.get(player) == 0) {
//        answer.get(0).add(player);
//      } else if (lossesCount.get(player) == 1) {
//        answer.get(1).add(player);
//      }
//    }
//    Collections.sort(answer.get(0));
//    Collections.sort(answer.get(1));
//    return answer;
//  }
//
//  /**
//   * Approach: Hash Set + Hash Map <br>
//   * Time Complexity: O(n * log(n)) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<List<Integer>> findWinners(int[][] matches) {
//    Set<Integer> seen = new HashSet<>();
//    Map<Integer, Integer> lossesCount = new HashMap<>();
//    for (int[] match : matches) {
//      int winner = match[0];
//      int loser = match[1];
//      seen.add(winner);
//      seen.add(loser);
//      lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
//    }
//    List<List<Integer>> answer = List.of(new ArrayList<>(), new ArrayList<>());
//    for (int player : seen) {
//      if (!lossesCount.containsKey(player)) {
//        answer.get(0).add(player);
//      } else if (lossesCount.get(player) == 1) {
//        answer.get(1).add(player);
//      }
//    }
//    Collections.sort(answer.get(0));
//    Collections.sort(answer.get(1));
//    return answer;
//  }
//
//  /**
//   * Approach: Hash Set <br>
//   * Time Complexity: O(n * log(n)) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<List<Integer>> findWinners(int[][] matches) {
//    Set<Integer> zeroLoss = new HashSet<>();
//    Set<Integer> oneLoss = new HashSet<>();
//    Set<Integer> moreLosses = new HashSet<>();
//    for (int[] match : matches) {
//      int winner = match[0];
//      int loser = match[1];
//      // Add winner
//      if (!oneLoss.contains(winner) && !moreLosses.contains(winner)) {
//        zeroLoss.add(winner);
//      }
//      // Add or move loser
//      if (zeroLoss.contains(loser)) {
//        zeroLoss.remove(loser);
//        oneLoss.add(loser);
//      } else if (oneLoss.contains(loser)) {
//        oneLoss.remove(loser);
//        moreLosses.add(loser);
//      } else if (moreLosses.contains(loser)) {
//        continue;
//      } else {
//        oneLoss.add(loser);
//      }
//    }
//    List<List<Integer>> answer = List.of(new ArrayList<>(), new ArrayList<>());
//    answer.get(0).addAll(zeroLoss);
//    answer.get(1).addAll(oneLoss);
//    Collections.sort(answer.get(0));
//    Collections.sort(answer.get(1));
//    return answer;
//  }
}
