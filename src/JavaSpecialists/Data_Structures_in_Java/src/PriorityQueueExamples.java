package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class PriorityQueueExamples {
  public static class Person implements Comparable<Person> {
    private final String name;

    public Person(String name) {
      this.name = name;
    }

    public int compareTo(Person o) {
      return name.compareTo(o.name);
    }
  }

  public static void main(String... args) {
    PriorityQueue<Person> pq = new PriorityQueue<>();
    // not stable sort order
    // unordered (???)
    // unbounded
    // priority thread pool

    int[] vals = {1,2,2,3,3,5};
    Person[] persons = {
        new Person("John"),
        new Person("Alison"),
        new Person("Alison"),
        new Person("Alison"),
        new Person("Peter"),
    };
    System.out.println("Before enqueue");
    Stream.of(persons).forEach(System.out::println);

    Stream.of(persons).forEach(pq::add);
    System.out.println("Deque order");
    while(!pq.isEmpty()) {
      System.out.println(pq.remove());
    }

    System.out.println(pq.spliterator().hasCharacteristics(Spliterator.ORDERED));
    System.out.println(pq.spliterator().hasCharacteristics(Spliterator.SORTED));

    ExecutorService priorityPool = new ThreadPoolExecutor(
        1, 1, 0, TimeUnit.SECONDS, new PriorityBlockingQueue<>()
    );

    priorityPool.submit(new PrioritizedRunnable(() ->
        System.out.println("I'm really important1"), 0));
    priorityPool.submit(new PrioritizedRunnable(() ->
        System.out.println("I'm not really important"), 10));
    priorityPool.submit(new PrioritizedRunnable(() ->
        System.out.println("I'm really important2"), 0));
  }
  private static class PrioritizedRunnable
      implements Runnable, Comparable<PrioritizedRunnable> {
    private final Runnable job;
    private int priority;

    public PrioritizedRunnable(Runnable job, int priority) {
      this.job = job;
      this.priority = priority;
    }

    public void run() {
      job.run();
    }

    public int compareTo(PrioritizedRunnable pr) {
      return Integer.compare(priority, pr.priority);
    }
  }
}
