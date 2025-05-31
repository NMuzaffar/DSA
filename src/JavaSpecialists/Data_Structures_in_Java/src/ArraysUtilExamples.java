package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

public class ArraysUtilExamples {
  public static void main(String... args) {
    System.out.println(Integer.compareUnsigned(
        0x8912_1123,
        0x4324_1324
    ));

    int[][] a = {{1,2,3}, {4}};
    int[][] b = {{1,2,3}, {4}};

    System.out.println(Arrays.deepEquals(a, b));

    System.out.println(Arrays.deepToString(a));

    int[] squares = new int[10_000];
    Arrays.parallelSetAll(squares, i -> i * i);
    System.out.println(Arrays.toString(squares));

    System.out.println(Arrays.compareUnsigned(new int[] {0x9876_5432, 0x1234_5678}, new int[] {0x1234_5678, 0x9876_5432}));
    System.out.println(Arrays.compare(new int[] {0x9876_5432, 0x1234_5678}, new int[] {0x1234_5678, 0x9876_5432}));

    testEquals();
  }

  private static void testEquals() {
    int[] a = {1,2,3};
    int[] b = {1,2,3};
    System.out.println("a.equals(b) = " + a.equals(b));
    System.out.println("b.equals(a) = " + b.equals(a));
    System.out.println("Arrays.equals(a, b) = " + Arrays.equals(a, b));
//    System.out.println("Arrays.deepEquals(a, b) = " + Arrays.deepEquals(a, b));
    System.out.println("(Arrays.hashCode(a) == Arrays.hashCode(b)) = " + (Arrays.hashCode(a) == Arrays.hashCode(b)));
//    System.out.println("(Arrays.deepHashCode(a) == Arrays.deepHashCode(b)) = " + (Arrays.deepHashCode(a) == Arrays.deepHashCode(b)));
  }


}
