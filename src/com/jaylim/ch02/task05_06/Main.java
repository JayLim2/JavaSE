package com.jaylim.ch02.task05_06;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(point.getX());
        System.out.println(point.getY());
    }
}
