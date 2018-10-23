package com.jaylim.ch04.task04_05;

import com.jaylim.ch04.task01_02_03.Point;

public abstract class Shape {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
    }

    public abstract Point getCenter();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Shape shape = (Shape) super.clone();
        shape.point = new Point(point.getX(), point.getY());
        return shape;
    }
}

