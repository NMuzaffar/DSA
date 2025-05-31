package JavaSpecialists.Data_Structures_in_Java.src;

import java.util.*;

class Student implements Comparable<Student> {
  private final int year;
  private final String name;
  private final double average;

  public Student(int year, String name, double average) {
    this.year = year;
    this.name = name;
    this.average = average;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return year == student.year && Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return 31 * year + (name != null ? name.hashCode() : 0);
  }

  public int compareTo(Student s) {
    int result = Integer.compare(year, s.year);
    return result != 0 ? result : name.compareTo(s.name);
  }

  public String toString() {
    return "Student " + name + " from year " + year +
        " had an average of " + average + "%";
  }

  public String getName() {
    return name;
  }

  public int getYear() {
    return year;
  }

  public double getAverage() {
    return average;
  }
}
