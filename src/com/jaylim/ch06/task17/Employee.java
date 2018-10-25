package com.jaylim.ch06.task17;

public class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    /*
    При компиляции создан мостовой метод:

    Compiled from "Employee.java"
    public class com.jaylim.ch06.task17.Employee implements java.lang.Comparable<com.jaylim.ch06.task17.Employee> {
      public com.jaylim.ch06.task17.Employee();
      public int compareTo(com.jaylim.ch06.task17.Employee);
      public int compareTo(java.lang.Object); - мостовой метод
    }
     */
}
