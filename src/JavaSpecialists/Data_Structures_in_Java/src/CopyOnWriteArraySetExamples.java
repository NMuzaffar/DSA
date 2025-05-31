package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class CopyOnWriteArraySetExamples {
  public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
    Set<Integer> oddBetweenMinusTenAndTen = new CopyOnWriteArraySet<>();
    oddBetweenMinusTenAndTen.addAll(
        Arrays.asList(-9, -7, -5, 5, -1, -3, 3, 1, 1, 1, 9, 7));
    System.out.println("oddBetweenMinusTenAndTen = " + // -9, -7, -5, 5, -1, -3, 3, 1, 9, 7
        oddBetweenMinusTenAndTen);

    Student s1 = new Student(1, "Peter", 33);
    Student s2 = new Student(1, "Peter", 98);
    Set<Student> students = new CopyOnWriteArraySet<>();
    students.add(s1);
    students.add(s2);
    System.out.println("students = " + students);

    for (int size = 1_000; size <= 128_000; size *= 2) {
      List<Integer> list = IntStream.range(0, size).boxed()
          .collect(Collectors.toList());
      long time = System.currentTimeMillis();
      try {
        CopyOnWriteArraySet<Integer> million = new CopyOnWriteArraySet<>(list);
      } finally {
        time = System.currentTimeMillis() - time;
        System.out.println("size=" + size + ", time = " + time + "ms");
      }
    }

//    Collections.shuffle(values, new Random(0));
//    values.forEach(i -> million.put(i, "dummy"));
//    System.out.println("million.size() = " + million.size());
//    Field parentField = null;
//    LongAccumulator maximumDepth = new LongAccumulator(Long::max, 0);
//    for (Map.Entry<Integer, Object> entry : million.entrySet()) {
//      if (parentField == null) {
//        parentField = entry.getClass().getDeclaredField("parent");
//        parentField.setAccessible(true);
//        System.out.println("parentField = " + parentField);
//      }
//      int level = 0;
//      Object node = entry;
//      while(node != null) {
//        level++;
//        node = parentField.get(node);
//      }
//      maximumDepth.accumulate(level);
//    }
//    System.out.println("maximumDepth = " + maximumDepth);
  }
}
