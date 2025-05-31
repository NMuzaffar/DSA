package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class ListExamples {
  public static void main(String... args) {
    List<String> names = List.of("John", "Anton"); // Java 9

    System.out.println(names.get(0));
    System.out.println(names.get(1));
    System.out.println(names);

    RandomAccess ra;

//    names.set(1, "Antony");
//
//    System.out.println(names);

//    names.add("Dirk");
//    names.clear();
  }
}
