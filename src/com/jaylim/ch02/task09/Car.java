package com.jaylim.ch02.task09;

/**
 * Класс, моделирующий движение автомобиля
 */
public class Car {
    private int tank; //л
    private int fuelConsumption; //км/л
    private int totalDistance; //км

    /**
     * Создание объекта автомобиля с указанием его
     * расхода топлива в км/л.
     * По умолчанию бак считается пустым.
     * По умолчанию пройденное расстояние считается равным 0.
     *
     * @param fuelConsumption расход топлива
     */
    public Car(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        tank = 0;
        totalDistance = 0;
    }

    /**
     * Перемещение на заданное количество километров
     * <p>
     * Если заданное количество больше предельно возможного
     * (с учетом показателя расхода топлива и объемом топлива
     * в баке перед началом движения), то автомобиль проедет
     * только максимально возможное количество километров.
     *
     * @param km необходимое количество км
     */
    public void moveOn(int km) {
        int maxKm = tank * fuelConsumption;
        if (km <= maxKm) {
            totalDistance += km;
        } else {
            totalDistance += maxKm;
        }
    }

    /**
     * Заполнение бака указанным количеством литров бензина
     *
     * @param volume количество литров
     */
    public void fillTank(int volume) {
        if (volume >= 0) {
            tank += volume;
        }
    }

    /**
     * Возвращзает суммарное расстояние,
     * пройденное от начала координат
     *
     * @return расстояние
     */
    public int getTotalDistance() {
        return totalDistance;
    }

    /**
     * Возвращает текущий объем бензина в баке
     *
     * @return объём бензина в баке
     */
    public int getTank() {
        return tank;
    }
}
