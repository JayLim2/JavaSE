package com.jaylim.ch05.task14;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HTMLFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!doctype html>");
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<style type=\"text/css\">" +
                "body { " +
                "font-family: arial;" +
                "font-size: 14pt;" +
                "</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<b>Message: </b>");
        stringBuilder.append(record.getMessage());
        stringBuilder.append("<br>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
