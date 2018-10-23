package com.jaylim.ch04.task04_05;

import com.jaylim.ch04.task01_02_03.Point;

class Line extends Shape implements Cloneable {
    private Point pointTo;

    public Line(Point pointFrom, Point pointTo) {
        super(pointFrom);
        this.pointTo = pointTo;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Line obj = (Line) super.clone();
        obj.pointTo = new Point(pointTo.getX(), pointTo.getY());
        return obj;
    }

    @Override
    public String toString() {
        return "Line{" +
                "point=" + point +
                ", pointTo=" + pointTo +
                '}';
    }

    public void setPointTo(Point pointTo) {
        this.pointTo = pointTo;
    }
}
