//package Structy.ch0_Introduction;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <a href="https://structy.net/problems/fizz-buzz">Fizz Buzz</a>
// */
//public class FizzBuzz {
//
//  public static void main(String[] args) {
//    assertEquals(
//        new ArrayList<>(List.of(1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11)),
//        fizzBuzz(11));
//
//    assertEquals(
//        new ArrayList<>(List.of(1, 2)),
//        fizzBuzz(2));
//
//    assertEquals(
//        new ArrayList<>(List.of(1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11, "fizz", 13, 14, "fizzbuzz", 16)),
//        fizzBuzz(16));
//
//    assertEquals(
//        new ArrayList<>(
//            List.of(1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11, "fizz", 13, 14, "fizzbuzz", 16,
//                17, "fizz", 19, "buzz", "fizz", 22, 23, "fizz", "buzz", 26, "fizz", 28, 29, "fizzbuzz", 31, 32)),
//        fizzBuzz(32));
//  }
//
//  /**
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static List<Object> fizzBuzz(int n) {
//    List<Object> answer = new ArrayList<>();
//    for (int i = 1; i <= n; i++) {
//      if (i % 3 == 0 && i % 5 == 0) {
//        answer.add("fizzbuzz");
//      } else if (i % 3 == 0) {
//        answer.add("fizz");
//      } else if (i % 5 == 0) {
//        answer.add("buzz");
//      } else {
//        answer.add(i);
//      }
//    }
//    return answer;
//  }
//}
