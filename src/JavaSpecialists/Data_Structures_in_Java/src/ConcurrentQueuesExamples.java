package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

public class ConcurrentQueuesExamples {
  public static void main(String... args) {
    Queue<Integer> clq = new ConcurrentLinkedQueue<>();

    System.out.println(clq.offer(1));
    System.out.println(clq.add(2));
    System.out.println(clq.poll());
    System.out.println(clq.poll());
    System.out.println(clq.poll());


    System.out.println(clq.size()); // O(n)

    LongAccumulator maxSize = new LongAccumulator(
        Long::max, 0);

    IntStream.range(0, 100_000_000)
        .parallel()
        .forEach(i -> {
          clq.offer(i);
          maxSize.accumulate(clq.size());
          clq.poll();
        });

    System.out.println("maxSize = " + maxSize);

    // lifo or fifo or some hybrid
    Deque<Integer> cld = new ConcurrentLinkedDeque<>();

  }
}
