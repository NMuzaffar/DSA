package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;
import java.util.concurrent.*;

public class MyObservable {
  private final Set<MyObserver> obs = new CopyOnWriteArraySet<>();

  public void addObserver(MyObserver o) {
    Objects.requireNonNull(o, "o == null");
    obs.add(o);
  }

  public void deleteObserver(MyObserver o) {
    obs.remove(o);
  }

  public void notifyObservers() {
    notifyObservers(null);
  }

  public void notifyObservers(Object arg) {
    for (MyObserver ob : obs) {
      ob.update(this, arg);
    }
  }

  public void deleteObservers() {
    obs.clear();
  }

  public int countObservers() {
    return obs.size();
  }
}