package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.concurrent.*;

public class SpecializedQueueExamples {
  //34. Highly specialized queues: DelayQueue,
  // SynchronousQueue, LinkedTransferQueue

  public static void main(String... args)
      throws InterruptedException {
    ScheduledExecutorService timer =
        Executors.newSingleThreadScheduledExecutor();
    DelayQueue dq; // releasing elements after some time

    SynchronousQueue<Integer> sq = new SynchronousQueue<>(true);
    for (int i = 0; i < 10; i++) {
      int finalI = i;
      new Thread(() -> {
        try {
          sq.put(finalI);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
      Thread.sleep(10);
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(sq.take());
    }

    LinkedTransferQueue ltq;
  }

}
