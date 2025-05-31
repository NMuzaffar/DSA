package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.concurrent.*;

public class ArrayBlockingQueueExamples {
  public static void main(String... args) {

    ExecutorService pool = new ThreadPoolExecutor(
        10, 100, 1, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(900)
    );

    for (int i = 0; i < 10_000; i++) {
      pool.submit(() -> {
        Thread.sleep(1_000);
        return null;
      });
    }
     // 100 threads
  }
}
