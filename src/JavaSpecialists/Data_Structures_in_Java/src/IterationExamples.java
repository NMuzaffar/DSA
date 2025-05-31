package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class IterationExamples {
  public static void main(String... args) {
    ArrayList<String> names = new ArrayList<>(
        Arrays.asList("John", "Anton", "Heinz"));
    names.forEach(name -> {
      if (name.contains("o")) names.remove(name);
    });
    System.out.println("names = " + names);
    names.listIterator(); //Erich Gamma et al - Design patterns
  }
}
