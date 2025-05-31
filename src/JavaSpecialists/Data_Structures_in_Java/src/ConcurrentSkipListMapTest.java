package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ConcurrentSkipListMapTest {
  public static void main(String... args) {
    Map<Integer, Integer> squares = new ConcurrentHashMap<>();
    IntStream.range(0, 10_000).parallel().forEach(
        i -> squares.put(i, i*i)
    );
    System.out.println("squares = " + squares);
    System.out.println("squares.size() = " + squares.size());

  }

}
