package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class StackExample {
  public static void main(String... args) {
    Stack<String> stack = new Stack<>(); // ConcurrentLinkedDeque
    stack.push("Tomatoes");
    stack.push("Carrots");
    stack.push("Cucumbers");
    while(!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

  }
}
