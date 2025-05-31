package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ParallelSortingExample {
  private static class ParallelSortingLinkedList<E> extends LinkedList<E> implements ParallelSortingList<E> {
    public ParallelSortingLinkedList() {
    }

    public ParallelSortingLinkedList(Collection<? extends E> c) {
      super(c);
    }
  }
  private static class ParallelSortingArrayList<E> extends ArrayList<E> implements ParallelSortingList<E> {
    public ParallelSortingArrayList(int initialCapacity) {
      super(initialCapacity);
    }

    public ParallelSortingArrayList() {
    }

    public ParallelSortingArrayList(Collection<? extends E> c) {
      super(c);
    }
  }

  public static void main(String... args) {
//    List<Integer> ll= new ParallelSortingArrayList<>(
    List<Integer> ll= new LinkedList<>(
//    List<Integer> ll= new ParallelSortingLinkedList<>(
        ThreadLocalRandom.current().ints(10_000_000).boxed().collect(Collectors.toList())
    );

    long time = System.currentTimeMillis();
    try {
      ll.sort(null);
    } finally {
      time = System.currentTimeMillis() - time;
      System.out.println("time = " + time + "ms");
    }
  }
}
