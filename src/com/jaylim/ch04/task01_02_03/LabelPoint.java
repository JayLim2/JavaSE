package com.jaylim.ch04.task01_02_03;

public class LabelPoint extends Point {
    private String label;

    public LabelPoint(double x, double y) {
        super(x, y);
    }

    public LabelPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        double testVar = x;
        return label;
    }

    public static void test() {
        //double testVar = x;
    }
}
