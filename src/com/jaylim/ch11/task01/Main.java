package com.jaylim.ch11.task01;

@Cloneable
public class Main {
    @Override
    protected Object clone() {
        /*
        Помечаем класс аннотацией @Cloneable
        В методе clone() проверяем, есть ли у класса
        аннотация (с помощью рефлексии)

        Если нет - выбрасываем CloneNotSupportedException

        Если предполагается, что клонируем всё - поля не помечаем аннотацией.
        Если предполагается, что клонируем только часть полей - помечаем.

        Вызываем супер.клон, если клонирование поддержано.
        Анализируем поля и вызываем их метод клон или пересоздаем по значениям.

        Формируем новый объект и возвращаем.
         */
        return null;
    }
}
