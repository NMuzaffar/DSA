package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class HashSetExamples {
  public static void main(String... args) {
    Set<String> oddBelowTwenty = new HashSet<>();
    oddBelowTwenty.add("1");
    oddBelowTwenty.add("3");
    oddBelowTwenty.add("5");
    oddBelowTwenty.add("7");
    oddBelowTwenty.add("9");
    oddBelowTwenty.add("11");
    oddBelowTwenty.add("13");
    oddBelowTwenty.add("15");
    oddBelowTwenty.add("17");
    oddBelowTwenty.add("19");
    System.out.println("oddBelowTwenty = " + oddBelowTwenty);

    Student s1 = new Student(1, "Peter", 33);
    Student s2 = new Student(1, "Peter", 98);
    Set<Student> students = new HashSet<>();
    students.add(s1);
    students.add(s2);
    System.out.println("students = " + students);

    int x = 1024;
    int y = 768;

    System.out.println("(x * y) = " + (x * y));
    Set<Integer> uniqueHashCodes = new HashSet<>();
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        uniqueHashCodes.add(new Pixel(i, j).hashCode());
      }
    }
    System.out.println("uniqueHashCodes = " + uniqueHashCodes.size());
  }
}
