package com.jaylim.ch01.task01_to_14;

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task7();    //unresolved
        //task8();
        //task09();
        //task10();
        /*System.out.println(task14());

        new Scanner(System.in).nextInt();
        new Random().nextInt();*/
        int a = -(65535 / 2);
        a &= 0xFF;
        System.out.println(a);
    }

    /**
     * 1. Напишите программу, вводящую целочисленное значение
     * и выводящую его в двоичной, восьмеричной и шестнадцатеричной форме.
     * Организуйте вывод обратного значения в виде шестнадцатеричного числа
     * с плавающей точкой.
     */
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input integer: ");
        int number = scanner.nextInt();
        System.out.printf("%x %o %s", number, number,
                Integer.toBinaryString(number));

        double fNumber = 1.0 / number;
        System.out.printf("%n%n %a", fNumber);
    }

    /**
     * Нормализация угла (от -оо до +оо) до пределов (0, 359)
     */
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input integer: ");
        int number = scanner.nextInt();

        int angle = number < -180 ? 360 + number % 360 : number % 360;
        System.out.println(angle);

        int angle2 = Math.floorMod(number, 360);
        System.out.println(angle2);
    }

    /**
     * Максимум из трех чисел: только иф, только метод макс
     */
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input integer 1: ");
        int number1 = scanner.nextInt();
        System.out.print("Input integer 2: ");
        int number2 = scanner.nextInt();
        System.out.print("Input integer 3: ");
        int number3 = scanner.nextInt();

        if (number1 > number2) {
            if (number1 > number3) {
                System.out.println(number1);
            } else {
                System.out.println(number3);
            }
        } else {
            if (number2 > number3) {
                System.out.println(number2);
            } else {
                System.out.println(number3);
            }
        }

        System.out.println(Math.max(Math.max(number1, number2), number3));
    }

    /**
     * Наименьшее и наибольшее положительные даблы
     */
    public static void task4() {
        System.out.println("MIN: " + Math.nextUp(0));
        System.out.println("MAX: " + Math.nextUp(Float.MAX_VALUE));
    }

    /**
     * doube > MAX_INT - приведение, что будет
     */
    public static void task5() {
        double num = Integer.MAX_VALUE;
        num *= 2;
        System.out.println(num);
        System.out.println((int) num);
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 1000! by BigInteger
     */
    public static void task6() {
        BigInteger val = new BigInteger("1");
        System.out.println(val);

        BigInteger len = new BigInteger("1000");
        BigInteger one = new BigInteger("1");
        for (BigInteger i = new BigInteger("2"); i.compareTo(len) <= 0; i = i.add(one)) {
            val = val.multiply(i);
        }

        System.out.println(val);
    }

    // FIXME: 10/23/2018 unresolved
    public static void task7() {
        Scanner scanner = new Scanner(System.in);

        short num1 = scanner.nextShort();
        num1 <<= 0xFF;

        //exception

        int a = Short.toUnsignedInt(num1);
        System.out.println(num1);
    }

    /**
     * Поиск всех непустых подстрок
     */
    public static void task8() {
        System.out.println("Input string: ");
        String str = new Scanner(System.in).nextLine();

        Set<String> substrs = new HashSet<>();
        int len = str.length();

        for (int i = 1; i <= len; i++) {    //длины
            for (int j = 0; j < len; j++) { //индекс начала
                String tmp = substring(str, j, i);
                substrs.add(tmp);
                //System.out.println("i = " + i + ", j = " + j + ", " + tmp + " ");
            }
            //System.out.println("----");
        }

        for (String substr : substrs) {
            System.out.println(substr);
        }
    }

    private static String substring(String src, int startIndex, int length) {
        if (src == null || src.isEmpty() || startIndex < 0 || length <= 0) {
            return "";
        }

        String result;
        if (startIndex + length > src.length()) {
            result = src.substring(startIndex);
        } else {
            result = src.substring(startIndex, startIndex + length);
        }

        return result;
    }

    /**
     * new string
     */
    public static void task9() {
        String a = "100";
        String b = "100";
        String c = String.valueOf(100);

        System.out.println("a == b: " + (a == b));
        System.out.println("a equals b: " + a.equals(b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a equals c: " + a.equals(c));
    }

    /**
     * random LONG, by 36
     */
    public static void task10() {
        Long number = new Random().nextLong();
        System.out.println(number);
        System.out.println(Long.toString(number, 36));
    }

    // FIXME: 10/23/2018 unresolved
    public static void task11() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();


    }

    // FIXME: 10/23/2018 unresolved
    public static void task12() {

    }

    /**
     * lottery, 1..49
     */
    public static void task13() {
        Random random = new Random();

        List<Byte> lotterySrc = new ArrayList<>();
        int len = 50;
        for (byte i = 1; i < len; i++) {
            lotterySrc.add(i);
        }

        List<Byte> lotteryRes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(len);
            lotteryRes.add(lotterySrc.remove(index));
        }
        class Cmp implements Comparator<Byte> {
            @Override
            public int compare(Byte o1, Byte o2) {
                return o1 - o2;
            }
        }
        lotteryRes.sort(new Cmp());
        lotteryRes.forEach((byteElem) -> System.out.print(byteElem + " "));
    }

    /**
     * Magic square
     */
    public static boolean task14() {
        Scanner scanner = new Scanner(System.in);

        String nextLine = scanner.nextLine();
        ArrayList<Integer[]> rows = new ArrayList<>();
        int p = 0;
        while (!nextLine.isEmpty()) {
            System.out.println("nextline = " + nextLine);
            String[] strings = nextLine.split(" ");
            Integer[] nums = new Integer[strings.length];
            for (int i = 0; i < strings.length; i++) {
                try {
                    nums[i] = Integer.valueOf(strings[i]);
                } catch (Exception e) {
                }
            }
            if (p > 0 && nums.length != rows.get(p - 1).length) {
                System.out.println("Different row lengths.");
                return false;
            }
            rows.add(nums);
            nextLine = scanner.nextLine();
            p++;
        }

        int rowsCount = rows.size();
        if (rowsCount == 0) {
            System.out.println("Empty matrix.");
            return false;
        }
        int colsCount = rows.get(0).length;
        if (rowsCount != colsCount) {
            System.out.println("No square matrix.");
            return false;
        }

        boolean isMagic = true;

        //Подсчет первичных сумм
        int sumMainDiag = 0;
        int sumSideDiag = 0;
        int sumRow = 0;
        int sumCol = 0;
        Integer[] tmp = null;
        for (int i = 0; i < rowsCount; i++) {
            tmp = rows.get(i);
            sumMainDiag += tmp[i];
            sumSideDiag += tmp[rowsCount - 1 - i];
        }

        if (sumMainDiag != sumSideDiag) {
            isMagic = false;
        }

        for (int i = 0; i < rowsCount && isMagic; i++) {
            for (int j = 0; j < rowsCount; j++) {
                sumRow += rows.get(i)[j];
                sumCol += rows.get(j)[i];
            }

            if (sumRow != sumMainDiag || sumRow != sumCol) {
                isMagic = false;
            }

            sumRow = 0;
            sumCol = 0;
        }

        return isMagic;
    }
}