package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SpecializedCollection {
  public static void main(String... args) {
    // 27. Highly specialized collections:
    // EnumSet, EnumMap, IdentityHashMap,
    // Properties, WeakHashMap

    EnumSet<Thread.State> states = EnumSet.allOf(
        Thread.State.class);
    states.remove(Thread.State.RUNNABLE);
    System.out.println("states = " + states);

    Map<Thread.State, LongAdder> timesInState =
        Collections.synchronizedMap(
            new EnumMap<>(Thread.State.class));


    IdentityHashMap<String, Integer> map =
        new IdentityHashMap<>();
    map.put("Hello", 42);
    System.out.println(map.get(new String("Hello")));

    Map<IdentityKey<String>, Integer> map2 =
        new ConcurrentHashMap<>();
    map2.put(new IdentityKey<>("Hello"), 42);
    System.out.println(map2.get(new IdentityKey(new String("Hello"))));

    Map<String, Integer> map3 = Collections.synchronizedMap(map);

    WeakHashMap wm;
    Properties prop = new Properties();
    int parallelism = Integer.parseInt(System.getProperty(
        "java.util.concurrent.ForkJoinPool.common.parallelism", "42"));
    int parallelismBetter = Integer.getInteger(
        "java.util.concurrent.ForkJoinPool.common.parallelism", 42);
  }

  private static class IdentityKey<K> {
    private final K key;

    public IdentityKey(K key) {
      this.key = key;
    }

    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      return key == ((IdentityKey<?>) o).key;
    }

    public int hashCode() {
      return System.identityHashCode(key);
    }
  }
}
