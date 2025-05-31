//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.*;
//
///**
// * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
// */
//public class Problem49 {
//
//  public static void main(String[] args) {
//    List<List<String>> anagramGroups = groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
//    anagramGroups.sort(Comparator.comparing(List::size));
//    assertTrue(anagramGroups.get(0).containsAll(Set.of("bat")));
//    assertTrue(anagramGroups.get(1).containsAll(Set.of("nat","tan")));
//    assertTrue(anagramGroups.get(2).containsAll(Set.of("ate","eat","tea")));
//
//    anagramGroups = groupAnagrams(new String[] {""});
//    anagramGroups.sort(Comparator.comparing(List::size));
//    assertTrue(anagramGroups.get(0).containsAll(Set.of("")));
//
//    anagramGroups = groupAnagrams(new String[] {"a"});
//    anagramGroups.sort(Comparator.comparing(List::size));
//    assertTrue(anagramGroups.get(0).containsAll(Set.of("a")));
//  }
//
//  /**
//   * Approach: Hash Map (Sorted String a Key) <br>
//   * Time Complexity: O(n * k log(k)) <br>
//   * Space Complexity: O(n * k) <br>
//   */
//  public static List<List<String>> groupAnagrams(String[] strs) {
//    if (strs.length == 0) {
//      return new ArrayList<>();
//    }
//    Map<String, List<String>> groups = new HashMap<>();
//    for (String str : strs) { // O(n)
//      char[] strCharArr = str.toCharArray();
//      Arrays.sort(strCharArr); // O(k log(k))
//      String key = String.valueOf(strCharArr);
//      groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
//    }
//    return new ArrayList<>(groups.values());
//  }
//
////  /**
////   * Approach: Hash Map (Char Count as a Key) <br>
////   * Time Complexity: O(n * k) <br>
////   * Space Complexity: O(n * k) <br>
////   */
////  public static List<List<String>> groupAnagrams(String[] strs) {
////    if (strs.length == 0) {
////      return new ArrayList<>();
////    }
////    Map<String, List<String>> groups = new HashMap<>();
////    for (String str : strs) { // O(n)
////      int[] charCounts = new int[26];
////      for (char c : str.toCharArray()) { // O(k)
////        charCounts[c - 'a']++;
////      }
////      StringBuilder sb = new StringBuilder();
////      for (int count : charCounts) { // O(A)
////        sb.append("#").append(count);
////      }
////      String key = new String(sb.toString());
////      groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
////    }
////    return new ArrayList<>(groups.values());
////  }
//}
