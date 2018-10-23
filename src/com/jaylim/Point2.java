package com.jaylim;

/**
 * Класс com.jaylim.Point2 описывает точку на декартовых координатах.
 * Аналогичен классу com.jaylim.Point, но в отличие от него является изменяемым.
 */
public final class Point2 {
    private double x;
    private double y;

    public Point2() {
        x = 0;
        y = 0;
    }

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получить Х
     *
     * @return координата Х точки
     */
    public double getX() {
        return x;
    }

    /**
     * Получить Y
     *
     * @return координата Y точки
     */
    public double getY() {
        return y;
    }

    /**
     * Переместить точку в другие координаты.
     * Модифицирует текущий объект.
     *
     * @param translateX смещение по оси X
     * @param translateY смещение по оси Y
     */
    public void translate(double translateX, double translateY) {
        x += translateX;
        y += translateY;
    }

    /**
     * Масштабировать точку.
     * Модифицирует текущий объект.
     *
     * @param val коэффициент масштабирования
     */
    public void scale(double val) {
        x *= val;
        y *= val;
    }
}
