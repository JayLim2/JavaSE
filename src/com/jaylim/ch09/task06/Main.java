package com.jaylim.ch09.task06;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {
        /*FileOutputStream out = new FileOutputStream("test");
        out.close();
        RandomAccessFile raf = new RandomAccessFile("test", "r");
        raf.seek(0);
        System.out.println(raf.readByte());
        System.out.println(raf.readByte());*/

        bmp("test1.bmp");
    }

    public static int byteArrayToInteger(byte[] bytes) {
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
    }

    public static void bmp(String filename) {
        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "r");
            raf.seek(14);
            byte intSize = 4;
            byte charSize = 2;
            byte[] headerSize = new byte[intSize];
            for (int i = 0; i < intSize; i++) {
                headerSize[intSize - 1 - i] = raf.readByte();
                //40 0 0 0 ?????????????
            }
            System.out.println("Header size " + byteArrayToInteger(headerSize));
            byte[] width = new byte[charSize];
            for (int i = 0; i < charSize; i++) {
                width[charSize - 1 - i] = raf.readByte();
                //40 0 0 0 ?????????????
            }
            //int width = raf.readInt();
            System.out.println("Width " + byteArrayToShort(width));
            int height = raf.readInt();
            System.out.println("Height " + height);
            char planes = raf.readChar();
            System.out.println("Number of planes " + (int) planes);
            char bitsPixel = raf.readChar();
            System.out.println("Bits per pixel " + (int) bitsPixel);
            int compressionType = raf.readInt();
            System.out.println("Compression type " + compressionType);
            int imageSize = raf.readInt();
            System.out.println("Image size " + imageSize);
            int horzRes = raf.readInt();
            System.out.println("Horizontal resolution " + horzRes);
            int vertRes = raf.readInt();
            System.out.println("Vertical resolution " + vertRes);
            int numColors = raf.readInt();
            System.out.println("Number of colors " + numColors);
            int numImpColors = raf.readInt();
            System.out.println("Number of important colors " + numImpColors);
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
