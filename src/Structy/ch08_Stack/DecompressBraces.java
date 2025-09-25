package Structy.ch08_Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://structy.net/problems/premium/decompress-braces">Decompress Braces</a>
 */
public class DecompressBraces {

  public static void main(String[] args) {
    assertEquals("qqtututuv", decompressBraces("2{q}3{tu}v"));
    assertEquals("chaoaoao", decompressBraces("ch3{ao}"));
    assertEquals("yoooyooos", decompressBraces("2{y3{o}}s"));
    assertEquals("zaxyxybaxyxybaxyxyb", decompressBraces("z3{a2{xy}b}"));
    assertEquals("reeeerreeeerreeeerioreeeerreeeerreeeerio", decompressBraces("2{3{r4{e}r}io}"));
    assertEquals("gospinningingsspinningingsspinningings", decompressBraces("go3{spinn2{ing}s}"));
    assertEquals("lififazulififazul", decompressBraces("2{l2{if}azu}l"));
    assertEquals("alececececiciaiciaalececececiciaiciaalececececiciaicia", decompressBraces("3{al4{ec}2{icia}}"));
  }

  /**
   * Time Complexity: O() <br>
   * Space Complexity: O() <br>
   */
  public static String decompressBraces(String str) {
    return "";
  }
}
