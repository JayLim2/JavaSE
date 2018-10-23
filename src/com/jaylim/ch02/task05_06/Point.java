package com.jaylim.ch02.task05_06;

/**
 * Класс com.jaylim.ch02.task05_06.Point2 описывает точку на декартовых координатах.
 * Неизменяемый класс.
 */
public final class Point {
    private double x;
    private double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получить Х.
     *
     * @return координата Х точки
     */
    public double getX() {
        return x;
    }

    /**
     * Получить Y.
     *
     * @return координата Y точки
     */
    public double getY() {
        return y;
    }

    /**
     * Переместить точку в другие координаты.
     * Возвращает новый объект с измененными координатами.
     *
     * @param translateX смещение по оси X
     * @param translateY смещение по оси Y
     */
    public Point translate(double translateX, double translateY) {
        return new Point(x + translateX, y + translateY);
    }

    /**
     * Масштабировать точку.
     * Возвращает новый объект с измененными координатами.
     *
     * @param val коэффициент масштабирования
     */
    public Point scale(double val) {
        return new Point(x * val, y * val);
    }
}
