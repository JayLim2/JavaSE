package com.jaylim.ch05.task14;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("com.jaylim.logger2");
        logger.setLevel(Level.FINE);
        FileHandler handler = new FileHandler("%h/myapp.html");
        handler.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        handler.setFormatter(new HTMLFormatter());

        logger.fine("AAAAAAAAAA");
    }
}

