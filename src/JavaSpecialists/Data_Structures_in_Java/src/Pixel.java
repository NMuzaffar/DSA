package JavaSpecialists.Data_Structures_in_Java.src;

public class Pixel implements Comparable<Pixel> {
  private final int x, y;

  public Pixel(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pixel pixel = (Pixel) o;
    return x == pixel.x && y == pixel.y;
  }

  public int hashCode() {
    return 31 * x + y; //x=0, y=31, hashCode=31
                       //x=1, y=0, hashCode=31
  }

  public int compareTo(Pixel o) { // safety valve
    int result = Integer.compare(x, o.x);
    if (result != 0) return result;
    return Integer.compare(x, o.x);
  }
}
