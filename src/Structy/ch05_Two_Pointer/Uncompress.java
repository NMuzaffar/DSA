//package Structy.ch05_Two_Pointer;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://structy.net/problems/premium/uncompress">Uncompress</a>
// */
//public class Uncompress {
//
//  public static void main(String[] args) {
//    assertEquals("ccaaat", uncompress("2c3a1t"));
//    assertEquals("ssssbb", uncompress("4s2b"));
//    assertEquals("ppoppppp", uncompress("2p1o5p"));
//    assertEquals("nnneeeeeeeeeeeezz", uncompress("3n12e2z"));
//    assertEquals(
//        "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
//        uncompress("127y"));
//  }
//
//  /**
//   * Time Complexity: O() <br>
//   * Space Complexity: O() <br>
//   */
//  public static String uncompress(String s) {
//    StringBuilder sb = new StringBuilder();
//    int n = s.length();
//    int numPtr = 0;
//    int charPtr = 0;
//    while (numPtr < n && charPtr < n) {
//      StringBuilder numStr = new StringBuilder();
//      while (numPtr < n && !Character.isDigit(s.charAt(numPtr))) {
//        numPtr++;
//      }
//
//      numStr.append(s.charAt(numPtr++));
//      while (numPtr < n && Character.isDigit(s.charAt(numPtr))) {
//        numStr.append(s.charAt(numPtr));
//        numPtr++;
//      }
//
//      while (charPtr < n && !Character.isLetter(s.charAt(charPtr))) {
//        charPtr++;
//      }
//
//      for (int i = 0; i < Integer.parseInt(numStr.toString()); i++) {
//        sb.append(s.charAt(charPtr));
//      }
//      numPtr++;
//      charPtr++;
//    }
//    return sb.toString();
//  }
//}
