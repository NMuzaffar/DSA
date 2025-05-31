package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentSkipListSetExample {
  public static void main(String... args) {
    ConcurrentSkipListSet<Integer> numbers =
        new ConcurrentSkipListSet<>(Collections.reverseOrder());
    ThreadLocalRandom.current().ints(100).forEach(numbers::add);
    System.out.println("numbers.size() = " + numbers.size());
    System.out.println("numbers = " + numbers);
  }
}
