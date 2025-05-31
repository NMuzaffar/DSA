package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class LinkedHashExamples {
  public static void main(String... args) {
    LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
    numbers.add(2);
    numbers.add(3);
    numbers.add(1);
    numbers.add(5);
    numbers.add(0);
    System.out.println("numbers = " + numbers);

    LinkedHashMap<Integer, Integer> squares =
        new LinkedHashMap<>(16, 0.75f, true);
    squares.put(1, 1);
    squares.put(3, 9);
    squares.put(12, 144);
    squares.put(15, 225);
    squares.put(16, 256);

    System.out.println("squares = " + squares);

    System.out.println("squares.get(12) = " + squares.get(12));
    System.out.println("squares = " + squares);

    LinkedHashMap<Integer, Integer> lruSquares = new LinkedHashMap<>(16, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > 5;
      }
    };

    for (int i = 0; i < 6; i++) {
      lruSquares.put(i, i*i);
    }
    System.out.println("lruSquares = " + lruSquares);
    System.out.println("lruSquares.get(4) = " + lruSquares.get(4));
    System.out.println("lruSquares = " + lruSquares);
    for (int i = 10; i < 15; i++) {
      lruSquares.put(i, i*i);
    }
    System.out.println("lruSquares = " + lruSquares);

  }
}
