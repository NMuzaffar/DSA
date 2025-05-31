package JavaSpecialists.Data_Structures_in_Java.src;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

public class TreeSetExamples {
  public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
    Set<Integer> oddBetweenMinusTenAndTen = new TreeSet<>();
    Collections.addAll(oddBetweenMinusTenAndTen,
        -9, -7, -5, 5, -1, -3, 3, 1, 1, 1, 9, 7
    );
    System.out.println("oddBetweenMinusTenAndTen = " +
        oddBetweenMinusTenAndTen);

    // red-black tree
    // adding values, 0-15
    /*
    0

    0
     \
      1

    0
     \
      1
       \
        2
    0
     \
      1
       \
        2
         \
          3


    5, 11, 2, 7, 8, 4

     5
   /    \
  2     11
   \    /
    4 7
       \
        8
     */

    Student s1 = new Student(1, "Peter", 33);
    Student s2 = new Student(1, "Peter", 98);
    Set<Student> students = new TreeSet<>();
    students.add(s1);
    students.add(s2);
    System.out.println("students = " + students);

    System.out.println("log 2 1_000_000: " + Math.log(1_000_000) / Math.log(2)); // 24 -  20
    System.out.println("log 2 10_000_000: " + Math.log(10_000_000) / Math.log(2)); // 28
    TreeMap<Integer, Object> million = new TreeMap<>();

    List<Integer> values = IntStream.range(0, 1_000_000).boxed().collect(Collectors.toList());
//    Collections.shuffle(values, new Random(0));
//    Collections.reverse(values);

    values.forEach(i -> million.put(i, "dummy"));
    System.out.println("million.size() = " + million.size());
    Field parentField = null;
    LongAccumulator maximumDepth = new LongAccumulator(Long::max, 0);
    for (Map.Entry<Integer, Object> entry : million.entrySet()) {
      if (parentField == null) {
        parentField = entry.getClass().getDeclaredField("parent");
        parentField.setAccessible(true);
        System.out.println("parentField = " + parentField);
      }
      int level = 0;
      Object node = entry;
      while(node != null) {
        level++;
        node = parentField.get(node);
      }
      maximumDepth.accumulate(level);
    }
    System.out.println("maximumDepth = " + maximumDepth);
  }
}
