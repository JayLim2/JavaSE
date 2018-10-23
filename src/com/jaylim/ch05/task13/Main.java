package com.jaylim.ch05.task13;

import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.jaylim.logger");
        logger.setLevel(Level.FINE);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        handler.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                String message = record.getMessage().toLowerCase();
                if (message.contains("sex") || message.contains("drugs") || message.contains("c++")) {
                    return false;
                }
                return true;
            }
        });

        logger.fine("this is error");
        logger.fine("the best programming lang is C++");
    }
}
