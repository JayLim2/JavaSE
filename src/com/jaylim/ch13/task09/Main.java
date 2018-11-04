package com.jaylim.ch13.task09;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle res = ResourceBundle.getBundle("test");
        System.out.println(res.getString("applicationName"));
        res = ResourceBundle.getBundle("test", Locale.US);
        System.out.println(res.getString("applicationName"));
    }
}
