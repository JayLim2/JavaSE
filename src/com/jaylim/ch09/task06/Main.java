package com.jaylim.ch09.task06;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        /*FileOutputStream out = new FileOutputStream("test");
        out.close();
        RandomAccessFile raf = new RandomAccessFile("test", "r");
        raf.seek(0);
        System.out.println(raf.readByte());
        System.out.println(raf.readByte());*/


        /*InputStream inputStream = new FileInputStream(new File("test1.bmp"));
        int b = inputStream.read();
        while (b != -1) {
            System.out.println(b);
            b = inputStream.read();
        }*/
        bmp("test1.bmp");
    }

    /*public static int byteArrayToInteger(byte[] bytes) {
        int ret = 0;
        for (int i = 0; i < 4 && i < bytes.length; i++) {
            ret <<= 8;
            ret |= (int) bytes[i] & 0xFF;
        }
        return ret;
    }

    public static int byteArrayToShort(byte[] bytes) {
        int ret = 0;
        for (int i = 0; i < 2 && i < bytes.length; i++) {
            ret <<= 8;
            ret |= (int) bytes[i] & 0xFF;
        }
        return ret;
    }*/

    public static int readInt(RandomAccessFile raf) {
        int ret = 0;
        try {
            byte size = 4;
            byte[] bytes = new byte[size];
            for (byte i = 0; i < size; i++) {
                bytes[size - 1 - i] = raf.readByte();
            }
            for (byte i = 0; i < size; i++) {
                ret <<= 8;
                ret |= (int) bytes[i] & 0xFF;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static short readShort(RandomAccessFile raf) {
        short ret = 0;
        try {
            byte size = 2;
            byte[] bytes = new byte[size];
            for (byte i = 0; i < size; i++) {
                bytes[size - 1 - i] = raf.readByte();
            }
            for (byte i = 0; i < size; i++) {
                ret <<= 8;
                ret |= (int) bytes[i] & 0xFF;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    /*
    Считывает 3 байта RGB и один байт-заполнение
     */
    public static int[] readColor(RandomAccessFile raf) {
        byte size = 3;
        int[] bytes = new int[size];
        try {
            for (byte i = 0; i < size; i++) {
                bytes[i] = raf.readByte();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }

    private static String colorByteArrayToString(int[] color) {
        return new StringBuilder()
                .append(color[0]).append(", ")
                .append(color[1]).append(", ")
                .append(color[2]).toString();
    }

    public static void bmp(String filename) {
        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "r");
            raf.seek(14);
            int headerSize = readInt(raf);
            System.out.println("Header size " + headerSize);
            int width = readInt(raf);
            System.out.println("Width " + width);
            int height = readInt(raf);
            System.out.println("Height " + height);
            short planes = readShort(raf);
            System.out.println("Number of planes " + planes);
            short bitsPixel = readShort(raf);
            System.out.println("Bits per pixel " + bitsPixel);
            int compressionType = readInt(raf);
            System.out.println("Compression type " + compressionType);
            int imageSize = readInt(raf);
            System.out.println("Image size " + imageSize);
            for (int i = 0; i < 64; i++) {
                System.out.println((int) raf.readByte());
            }
            int horzRes = readInt(raf);
            System.out.println("Horizontal resolution " + horzRes);
            int vertRes = readInt(raf);
            System.out.println("Vertical resolution " + vertRes);
            int numColors = readInt(raf);
            System.out.println("Number of colors " + numColors);
            int numImpColors = readInt(raf);
            System.out.println("Number of important colors " + numImpColors);

            raf.seek(54);
            //Далее идет матрица пикселей (т.к. изображение 8 битное)
            for (int row = height - 1; row >= 0; row--) {
                for (int col = 0; col < width; col++) {
                    /*
                    т.к. пиксели записаны по принципу (j, i) снизу вверх
                    то мы сначала получаем (0,1), потом (1,1), затем
                    (0,0), затем (1,0)
                    при том что первое число - номер столбца !!!!
                                второе число - номер строки !!!!
                     */
                    // FIXME: 07.11.2018 дописать чтение байтов
                    /*
                    ВАЖНО
                    2 раза читаем пиксели, затем читаем заполнение 2 байта!!!
                     */
                    System.out.printf("(%d, %d): %s %n", col, row, colorByteArrayToString(readColor(raf)));
                }
                raf.readByte();
            }

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
