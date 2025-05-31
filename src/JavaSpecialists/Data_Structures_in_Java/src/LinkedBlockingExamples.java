package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.concurrent.*;

public class LinkedBlockingExamples {
  public static void main(String... args)
      throws InterruptedException {
    LinkedBlockingDeque d;
    long time = System.currentTimeMillis();
    try {
      ExecutorService pool = Executors.newWorkStealingPool(10);
      for (int i = 0; i < 10_000_000; i++) {
        pool.submit(() -> {
        });
      }
      pool.shutdown();
      while (!pool.awaitTermination(1, TimeUnit.SECONDS)) ;
    } finally {
      time = System.currentTimeMillis() - time;
      System.out.println("time = " + time + "ms");
    }
  }
}
