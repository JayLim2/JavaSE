package com.jaylim.ch12.task12;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<ZonedDateTime> events = new ArrayList<>();

    public static void main(String[] args) {
        ZonedDateTime d1 = ZonedDateTime.of(LocalDateTime.of(2018, 11, 4, 15, 13, 0), ZoneId.of("Europe/Moscow"));
        ZonedDateTime d2 = ZonedDateTime.of(LocalDateTime.of(2018, 11, 4, 14, 21, 0), ZoneId.of("Europe/Berlin"));
        events.add(d1);
        events.add(d2);
        List<ZonedDateTime> planned = eventInNextHour();
        for (ZonedDateTime time : planned) {
            System.out.println(time);
        }
    }

    public static List<ZonedDateTime> eventInNextHour() {
        List<ZonedDateTime> list = new ArrayList<>();

        for (ZonedDateTime zonedDateTime : events) {
            ZonedDateTime zonedDateTimeHere = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
            ZonedDateTime plannedEventInLocalZone = zonedDateTime.withZoneSameInstant(ZoneId.systemDefault());
            if (Double.compare((double) Duration.between(zonedDateTimeHere, plannedEventInLocalZone).toMinutes() / 60, 1) <= 0) {
                list.add(zonedDateTime);
            }
        }

        return list;
    }
}
