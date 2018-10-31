package com.jaylim.ch09.task09;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://auth-demo.aerobaticapp.com/protected-custom/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String username = "aerobatic";
        String password = "aerobatic";
        String input = username + ":" + password;
        String encoding = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoding);
        connection.setRequestProperty("Authorization", "Basic " + encoding);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);

        if (connection.getResponseCode() == 200) {
            Scanner reader = new Scanner(new InputStreamReader(connection.getInputStream()));
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } else {
            System.out.println("Unauthorized and something else.");
        }
    }
}
