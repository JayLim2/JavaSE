package com.jaylim.ch03.task01_02;

public class Employee implements Measurable {
    private static int lastId = 0;
    private int id;
    private double salary;

    public Employee(double salary) {
        lastId++;
        id = lastId;
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects) {
        double sum = 0;
        int len = objects.length;
        for (int i = 0; i < len; i++) {
            sum += objects[i].getMeasure();
        }
        sum /= len;
        return sum;
    }

    public static Measurable largest(Measurable[] objects) {
        int len = objects.length;
        Measurable largest = null;
        if (len > 0) {
            largest = objects[0];
            for (int i = 1; i < len; i++) {
                if (objects[i].getMeasure() > largest.getMeasure()) {
                    largest = objects[i];
                }
            }
        }
        return largest;
    }
}
