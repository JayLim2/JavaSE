package com.jaylim.ch04.task04_05;

import com.jaylim.ch04.task01_02_03.Point;

class Circle extends Shape implements Cloneable {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
