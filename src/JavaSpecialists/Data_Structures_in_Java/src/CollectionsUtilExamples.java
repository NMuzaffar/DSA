package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;


public class CollectionsUtilExamples {
  public static void main(String... args) {
    List<String> names = Collections.checkedList(
        new ArrayList<>(), String.class);
    Collections.addAll(names, "John", "Anton", "Heinz");
    for (String name : names) {
      System.out.println("name = " + name);
    }
    List unchecked = names;
    unchecked.add(42); // CCE
    for (String name : names) {
      System.out.println("name = " + name);
    }

    List<String> empty = Collections.emptyList();

    Set<Integer> set = Collections.newSetFromMap(
        new ConcurrentHashMap<>()
    );
    set = ConcurrentHashMap.newKeySet();


    List.of(1);
    Map.of();
    Set.of();

    Collections.synchronizedCollection(new ArrayList<>());
    Collections.unmodifiableList(new ArrayList<>(names));

    Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));


  }
}
