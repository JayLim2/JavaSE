package com.jaylim.ch12.task09;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        offset(LocalDateTime.now());
    }

    public static void offset(LocalDateTime dateTime) {
        Stream<String> zones = ZoneId.getAvailableZoneIds().stream();
        zones.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                ZoneId zoneId = ZoneId.of(s);
                ZonedDateTime current = ZonedDateTime.of(dateTime, zoneId);
                ZonedDateTime original = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
                Duration duration = Duration.between(current, original);

                System.out.println(zoneId + ": " + Duration.between(current, original).toHours());
            }
        });
    }
}
