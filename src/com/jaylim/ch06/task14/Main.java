package com.jaylim.ch06.task14;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> list) {
        class CloseResourceException extends RuntimeException {
            private CloseResourceException() {
                super();
            }

            private CloseResourceException(String message) {
                super(message);
            }

            private CloseResourceException(String message, Throwable cause) {
                super(message, cause);
            }
        }

        CloseResourceException exception = null;

        for (T t : list) {
            try {
                t.close();
            } catch (Exception ex) {
                if (exception == null) {
                    exception = new CloseResourceException("Close resource exception. ");
                } else {
                    throw new CloseResourceException("Close resource exception. ", exception);
                }
            }
        }
    }
}
