package com.jaylim.ch03.task01_02;

public class Employee implements Measurable {
    private static int lastId = 0;
    private int id;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        lastId++;
        id = lastId;
        this.name = name;
        this.salary = salary;
    }

    //getName added for resolving ch03.task14
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Employee:\n");
        stringBuilder.append("\tid: ");
        stringBuilder.append(id);
        stringBuilder.append("\n");
        stringBuilder.append("\tname: ");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("\tsalary: ");
        stringBuilder.append(salary);
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }
}
