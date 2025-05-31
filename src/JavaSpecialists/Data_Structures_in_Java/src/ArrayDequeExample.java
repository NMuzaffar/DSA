package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class ArrayDequeExample {
  public static void main(String... args) {
    ArrayDeque<Integer> ad = new ArrayDeque<>();
    ad.add(1);
    ad.add(2);
    ad.add(3);
    ad.offer(3);
    ad.poll();
    ad.peek();
    ad.remove();
//    ad.element(); // throws

    for (int i = 0; i < 10_000; i++) {
      ad.add(i);
    }
    System.out.println(ad);

    ad.clear();

    System.out.println(ad);
  }
}
