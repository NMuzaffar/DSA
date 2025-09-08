//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//
///**
// * <a href="https://leetcode.com/problems/sort-features-by-popularity/">1772. Sort Features by Popularity</a>
// */
//public class Problem1772 {
//
//  public static void main(String[] args) {
//    assertArrayEquals(
//        new String[] {"touch","cooler","lock"},
//        sortFeatures(new String[] {"cooler","lock","touch"}, new String[] {"i like cooler cooler","lock touch cool","locker like touch"}));
//
//    assertArrayEquals(
//        new String[] {"a","aa","b","c"},
//        sortFeatures(new String[] {"a","aa","b","c"}, new String[] {"a","a aa","a a a a a","b a"}));
//  }
//
//  /**
//   * Approach: <br>
//   * Time Complexity: O() <br>
//   * Space Complexity: O() <br>
//   */
//  public static String[] sortFeatures(String[] features, String[] responses) {
//    int n = features.length;
//    Map<String, Integer> featuresFreqs = new HashMap<>();
//    Map<String, Integer> featuresIndexMap = new HashMap<>();
//    for (int i = 0; i < n; i++) {
//      featuresIndexMap.put(features[i], i);
//      featuresFreqs.put(features[i], 0);
//    }
//    for (String response : responses) {
//      for (String word : new HashSet<>(Arrays.asList(response.split("\\s+")))) {
//        if (featuresFreqs.containsKey(word)) {
//          featuresFreqs.put(word, featuresFreqs.get(word) + 1);
//        }
//      }
//    }
//    String[] ans = Arrays.copyOf(features, n);
//    Arrays.sort(ans, (f1, f2) -> {
//      int compareFreqs = Integer.compare(featuresFreqs.get(f2), featuresFreqs.get(f1));
//      return (compareFreqs != 0)
//          ? compareFreqs
//          : Integer.compare(featuresIndexMap.get(f1), featuresIndexMap.get(f2));
//    });
//    return ans;
//  }
//}
