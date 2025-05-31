package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class SortExample {
  public static void main(String... args) {
    List<Student> names = Arrays.asList(
        new Student(1, "John", 56.0),
        new Student(2, "John", 86.0),
        new Student(3, "Heinz", 72.0),
        new Student(3, "Anton", 56.0));
    names.sort(new Comparator<Student>() {
      public int compare(Student s1, Student s2) {
        int result = s1.getName().compareTo(s2.getName());
        return result != 0 ? result : Integer.compare(s1.getYear(), s2.getYear());
      }
    });

    Comparator<Student> grade =
        Comparator.comparingDouble(Student::getAverage).thenComparing(Student::getName);
    System.out.println(names);

    // by grade, best first
    names.sort(Comparator.comparingDouble(Student::getAverage)
        .reversed()
        .thenComparing(Student::getName)
        .thenComparingInt(Student::getYear)
    );
//    names.sort((s1, s2) -> {
//      int result = Double.compare(s1.getAverage(), s2.getAverage());
//      if (result == 0) {
//        result = s1.getName().compareTo(s2.getName());
//      }
//      if (result == 0) {
//        result = Integer.compare(s1.getYear(), s2.getYear());
//      }
//      return result;
//    });
    System.out.println(names);

    List<Integer> numbers = fillWithLotsOfRandomValues();
    for (int i = 0; i < 10; i++) {
      testSortingSpeed(numbers);
    }

  }


  private static void testSortingSpeed(List<Integer> numbers) {
    List<Integer> arrayList = new ArrayList<>(numbers);
    List<Integer> linkedList = new LinkedList<>(numbers);
    List<Integer> parallelSortingArrayList = new ParallelSortingArrayList<>(numbers);

    sortList(arrayList);
    sortList(parallelSortingArrayList);
    System.out.println("Already sorted");
    for (int i = 0; i < 5; i++) {
      sortList(arrayList);
      sortList(parallelSortingArrayList);
    }
  }

  private static void sortList(List<Integer> list) {
    long time = System.currentTimeMillis();
    list.sort(null);
    time = System.currentTimeMillis() - time;
    System.out.println(list.getClass().getSimpleName() + " time = " + time);
  }

  private static List<Integer> fillWithLotsOfRandomValues() {
    return ThreadLocalRandom.current().ints(10_000_000).parallel().boxed()
        .collect(Collectors.toList());
  }
}
