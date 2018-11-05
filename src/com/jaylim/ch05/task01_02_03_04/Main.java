package com.jaylim.ch05.task01_02_03_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Chapter 5
 * Tasks 01 to 04
 */
public class Main {
    public static void main(String[] args) {
        //Task01
        /*List<Double> list = readValues("task01_02.txt");
        for (Double aDouble : list) {
            System.out.println(aDouble);
        }*/

        //Task02-03
        /*try {
            System.out.println(sumOfValues("task01_02.txt"));
        } catch (NumberFormatException ex) {
            System.out.println("В файле встречены данные, не являющиеся числом с плавающей запятой.");
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/

        //Task04
        System.out.println(sumOfValues2("task01___.txt"));
    }

    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(new FileReader(file));
        ArrayList<Double> list = new ArrayList<>();
        /*while (scanner.hasNext()) {
            try {
                Double dVal = Double.parseDouble(scanner.next());
                list.add(dVal);
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Value is not floating point values.");
            }
        }*/

        while (scanner.hasNextDouble()) {
            Double dVal = scanner.nextDouble();
            list.add(dVal);
        }

        if (scanner.hasNext())
            throw new NumberFormatException("Value is not floating point value.");

        return list;
    }

    public static double sumOfValues(String filename) throws Exception {
        List<Double> values = readValues(filename);
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        return sum;
    }

    //--------------------------------------

    public static ArrayList<Double> readValues2(String filename) {
        ArrayList<Double> list = new ArrayList<>();
        double errCode = 0;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(new FileReader(file));
            /*while (scanner.hasNext()) {
                try {
                    Double dVal = Double.parseDouble(scanner.next());
                    list.add(dVal);
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException("Value is not floating point values.");
                }
            }*/

            while (scanner.hasNextDouble()) {
                Double dVal = scanner.nextDouble();
                list.add(dVal);
            }

            if (scanner.hasNext())
                errCode = new NumberFormatException("Value is not floating point value.").hashCode();

            list.add(errCode);
        } catch (FileNotFoundException ex) {
            list.add((double) ErrorCodes.FILE_NOT_FOUND);
        }
        return list;
    }

    public static double sumOfValues2(String filename) {
        try {
            List<Double> values = readValues2(filename);
            double sum = 0;
            for (Double value : values) {
                sum += value;
            }
            return sum;
        } catch (Exception ex) {
            return ErrorCodes.EXCEPTION;
        }
    }
}
