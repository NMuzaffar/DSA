package JavaSpecialists.Data_Structures_in_Java.src;

public class ArraysExamples {
  public static void main(String... args) {
    int[] values = {1, 2, 3};
    // object header 12 bytes 64-bit, compressedOops
    // length = 4 bytes
    // 3 x 4 bytes for values
    // 12 + 4 + 12 = 28 ≈ 32 bytes
    // O(n)
    int[] larger = new int[1000];
    // object header 12 bytes 64-bit, compressedOops
    // length = 4 bytes
    // 1000 x 4 bytes for values
    // 12 + 4 + 4000 = 4016
    // O(n)
    short[] smaller; // 2 bytes per entry
    byte[] bytes; // 1 byte per entry
    char[] c;

    String[] names = {"John", "Dane", "Dora"};
    String[] newNames = new String[names.length + 1];
    System.arraycopy(names, 0, newNames, 0, names.length);
    newNames[3] = "Heinz";

    int[][][][] quadro = {{{{1,2},{3,4}}}};
    int[][][] sub = quadro[0];
    int[][] subsub = sub[0];
    int[] subsubsub = subsub[1];
    int subsubsubsub = subsubsub[1];
    System.out.println("subsubsubsub = " + subsubsubsub);

    // favour single over multi-dim arrays
  }
}
