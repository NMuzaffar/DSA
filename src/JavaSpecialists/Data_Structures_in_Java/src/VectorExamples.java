package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class VectorExamples {
  public static void main(String... args) {
    Vector<String> names = new Vector<>(
        Arrays.asList("John", "Anton", "Heinz")
    );
    List<String> namesSafe = Collections.synchronizedList(
        new ArrayList<>(Arrays.asList("John", "Anton", "Heinz")));
  }
}
