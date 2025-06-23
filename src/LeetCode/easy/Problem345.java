package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>
 */
public class Problem345 {

  public static void main(String[] args) {
    assertEquals("AceCreIm", reverseVowels("IceCreAm"));
    assertEquals("leotcede", reverseVowels("leetcode"));
    assertEquals("ia", reverseVowels("ai"));
    assertEquals("holle", reverseVowels("hello"));
    assertEquals("fibracitang", reverseVowels("fabricating"));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String reverseVowels(String s) {
    boolean[] isVowel = new boolean[128];
    for (char c : "aeiouAEIOU".toCharArray()) {
      isVowel[c] = true;
    }
    char[] chArr = s.toCharArray();
    int left = 0;
    int right = chArr.length - 1;
    while (left < right) {
      while (left < right && !isVowel[chArr[left]]) {
        left++;
      }
      while (left < right && !isVowel[chArr[right]]) {
        right--;
      }
      if (left < right) {
        char temp = chArr[left];
        chArr[left] = chArr[right];
        chArr[right] = temp;
        left++;
        right--;
      }
    }
    return new String(chArr);
  }
}
