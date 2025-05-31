//package Structy.ch1_Hashing;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <a href="https://structy.net/problems/anagrams">Anagrams</a>
// */
//public class Anagrams {
//
//  public static void main(String[] args) {
//    assertTrue(anagrams("restful", "fluster"));
//    assertFalse(anagrams("cats", "tocs"));
//    assertTrue(anagrams("monkeyswrite", "newyorktimes"));
//    assertFalse(anagrams("paper", "reapa"));
//    assertTrue(anagrams("elbow", "below"));
//    assertFalse(anagrams("tax", "taxi"));
//    assertFalse(anagrams("taxi", "tax"));
//    assertTrue(anagrams("night", "thing"));
//    assertFalse(anagrams("abbc", "aabc"));
//    assertFalse(anagrams("po", "popp"));
//    assertFalse(anagrams("pp", "oo"));
//  }
//
//  /**
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(1) <br>
//   */
//  public static boolean anagrams(String s1, String s2) {
//    if (s1.length() != s2.length()) {
//      return false;
//    }
//    int N = s1.length();
//    Map<Character, Integer> charCounter = new HashMap<>();
//    for (int i = 0; i < N; i++) {
//      char c1 = s1.charAt(i);
//      charCounter.put(c1, charCounter.getOrDefault(c1, 0) + 1);
//      char c2 = s2.charAt(i);
//      charCounter.put(c2, charCounter.getOrDefault(c2, 0) - 1);
//    }
//    for (char c : charCounter.keySet()) {
//      if (charCounter.get(c) != 0) {
//        return false;
//      }
//    }
//    return true;
//  }
//}
