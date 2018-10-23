package com.jaylim.ch04.task04_05;

import com.jaylim.ch04.task01_02_03.Point;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Line line = new Line(new Point(10, 20), new Point(15, 30));
        Line line1 = (Line) line.clone();

        line1.setPointTo(new Point(255, 255));

        System.out.println(line);
        System.out.println();
        System.out.println(line1);
    }
}
