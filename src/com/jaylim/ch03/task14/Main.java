package com.jaylim.ch03.task14;

import com.jaylim.ch03.task01_02.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Employee[] arr;
        Employee e1 = new Employee("Johns", 10000);
        Employee e2 = new Employee("Davis", 10000);
        Employee e3 = new Employee("Smith", 25000);
        Employee e4 = new Employee("Bell", 7000);
        arr = new Employee[]{e1, e2, e3, e4};
        Arrays.sort(arr, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getMeasure(), o2.getMeasure());
            }
        }.thenComparing(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }));
        for (Employee employee : arr) {
            System.out.println(employee);
        }
    }
}
