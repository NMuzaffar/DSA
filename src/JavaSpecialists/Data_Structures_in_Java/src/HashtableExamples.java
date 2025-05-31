package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class HashtableExamples {
  public static class Person {
    private final String name;

    public Person(String name) {
      this.name = name;
    }

    public int hashCode() {
      return 1;
    }

    public boolean equals(Object obj) {
      if (!(obj instanceof Person)) return false;
      System.out.println("equals(" + ((Person)obj).name + ")");
      return name.equals(((Person)obj).name);
    }
  }

  public static void main(String... args) {
    Map<Person, Object> map = new Hashtable<>();
    map.put(new Person("Heinz"), "dummy");
    map.put(null, null);
    System.out.println(map);
    System.out.println(map.get(new Person("John")));
    map.putIfAbsent(null, "oopsie");
    System.out.println("map = " + map);
  }
}
