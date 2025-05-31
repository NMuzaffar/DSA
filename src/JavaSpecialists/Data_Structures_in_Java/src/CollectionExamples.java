package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;

public class CollectionExamples {
  public static void main(String... args) {
    Map m4 = new HashMap();
    Map m1 = new ConcurrentHashMap();

    Map m9 = new TreeMap();
    Map m2 = new ConcurrentSkipListMap();

    Map m5 = new Hashtable(); // historical - don't use

    Map m7 = new LinkedHashMap();

    Map m3 = new EnumMap(Thread.State.class);
    Map m6 = new IdentityHashMap();
    Map m8 = new Properties();
    Map m10 = new WeakHashMap();

    List c3 = new ArrayList();
    List c8 = new CopyOnWriteArrayList();
    List c16 = new LinkedList();


    List c23 = new Vector(); // historical - don't use
    Collection c20 = new Stack(); // historical - don't use

//BitSet s = new BitSet();

    Set c22 = new TreeSet();
    Set c7 = new ConcurrentSkipListSet();

    Set c12 = new HashSet();
    Set c4 = ConcurrentHashMap.newKeySet();

    Set c9 = new CopyOnWriteArraySet(); // rather don't use
    Set c11 = EnumSet.allOf(Thread.State.class);
    Set c15 = new LinkedHashSet();

    Queue c6 = new ConcurrentLinkedQueue();
    Queue c5 = new ConcurrentLinkedDeque();

    Queue c1 = new ArrayBlockingQueue(10);
    Queue c10 = new DelayQueue();
    Queue c13 = new LinkedBlockingDeque();
    Queue c14 = new LinkedBlockingQueue();
    Queue c17 = new LinkedTransferQueue(); // rather don't use
    Queue c18 = new PriorityBlockingQueue();
    Queue c21 = new SynchronousQueue();

    Queue c2 = new ArrayDeque();
    Queue c19 = new PriorityQueue();
  }
}
