package com.jaylim.ch09.task07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MDExample {
    public static final String SHA1 = "SHA-1";

    public static void main(String[] args) {
        byte[] mdbytes = getMessageDigest(SHA1, "helo world");
        String mdhex = toHexString(mdbytes);
        System.out.println(mdhex);
    }

    public static String hashFile(String filename) {
        StringBuilder hashed = new StringBuilder();
        try (Scanner scanner = new Scanner(Files.newBufferedReader(Paths.get(filename)))) {
            while (scanner.hasNextLine()) {
                hashed.append(toHexString(getMessageDigest(SHA1, scanner.nextLine())));
            }
        } catch (IOException ex) {
            System.out.println("Input/Output exception.");
        }
        return hashed.toString();
    }

    public static byte[] getMessageDigest(final String algo, final String text) {
        if ((algo == null) || (algo.trim().length() == 0) || (text == null))
            return null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algo);
            md.update(text.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (md != null)
            return md.digest();
        else
            return null;
    }

    public static String toHexString(byte[] bytes) {
        byte[] mdbytes = getMessageDigest("SHA-1", "helo world");
        StringBuilder stringBuilder = new StringBuilder();
        // convert the byte to hex format
        for (int j = 0; j < mdbytes.length; j++) {
            String s = Integer.toHexString(0xff & mdbytes[j]);
            s = (s.length() == 1) ? "0" + s : s;
            stringBuilder.append(s);
        }
        //return String.format("%x", stringBuilder.toString());
        return stringBuilder.toString();
    }
}
