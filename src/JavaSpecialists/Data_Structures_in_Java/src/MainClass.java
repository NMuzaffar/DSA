package JavaSpecialists.Data_Structures_in_Java.src;

public class MainClass {
  public static void main(String[] args) {
    startHelloThread();
    startByeThread();
    System.out.println("Goodbye main thread!");
  }

  private static void startHelloThread() {
    Thread helloThread = new Thread(() -> {
      System.out.println("Hello");
      try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }, "helloThread");
    helloThread.setDaemon(true);
    helloThread.start();
  }

  private static void startByeThread() {
    Thread byeThread = new Thread(() -> {
      System.out.println("Bye");
      try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
    },"byeThread");
    byeThread.start();
  }
}