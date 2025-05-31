package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;

public class HashingExamples {
  public static void main(String... args) {
    BasicHashtable<Integer, String> numbers = new BasicHashtable<>();
    numbers.put(1, "one");
    numbers.put(2, "two");
    numbers.put(42, "THE number"); // hash=42
    numbers.put(243, "two-four-three");
    numbers.put(244, "two-four-four"); // hash=244%101 = 42

    System.out.println("numbers = " + numbers);

    new HashMap<>().put(null, "String");

//    new ConcurrentHashMap<>().put(null, "String");

    Map<String, String> map = new HashMap<>();
    map.putIfAbsent(null, null);
    map.putIfAbsent(null, "oopsie");
    System.out.println("map = " + map);
  }
}
