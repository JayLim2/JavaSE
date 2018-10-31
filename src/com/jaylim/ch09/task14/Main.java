package com.jaylim.ch09.task14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(154, 999);
        String pointPath = "point.txt";
        //writePointToFile(point, pointPath);
        Point dPoint = readPointFromFile(pointPath);
        System.out.println(point);
        System.out.println(dPoint);

        /*
        task 15

        com.jaylim.ch09.task14.Point; local class incompatible:
        stream classdesc serialVersionUID = 4808282245328131050,
        local class serialVersionUID = 4056187759621062407

        Т.к. изменилась версия, было выброшено исключение в связи
        с несоответствием версий

        Если принудительно зафиксировать serialVersionUID, то данное
        исключение выброшено не будет, но десериализация будет проведена
        некорректно (в частности, в данном примере будет возвращен null).

        Чтобы сохранить совместимость, необходимо выполнять изменения реализации
        таким образом, чтобы не нарушался прежний контракт класса (т.е. не исчезали
        прежние поля и методы), но добавление новых вполне допустимо. При
        десериализации старой версии в такой класс будет успешным, правда
        новые элементы будут проигнорированы и инициализированы по дефолту.
         */
    }

    public static void writePointToFile(Point point, String path) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)))) {
            out.writeObject(point);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Point readPointFromFile(String path) {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(path)))) {
            return (Point) in.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Deserializing class doesn't exists.");
        }
        return null;
    }
}

class Point implements Serializable {
    public static final long serialVersionUID = 4808282245328131050L;
    private int[] coords;

    public Point(int x, int y) {
        coords = new int[2];
        coords[0] = x;
        coords[1] = y;
    }

    public int getX() {
        return coords[0];
    }

    public void setX(int x) {
        coords[0] = x;
    }

    public int getY() {
        return coords[1];
    }

    public void setY(int y) {
        coords[1] = y;
    }

    /*private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }*/

    @Override
    public String toString() {
        return "Point{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
