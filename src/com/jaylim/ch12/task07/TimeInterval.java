package com.jaylim.ch12.task07;

import com.sun.istack.internal.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class TimeInterval {
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private static List<TimeInterval> events = new ArrayList<>();

    public TimeInterval(LocalDateTime startEvent, LocalDateTime endEvent) {
        boolean noReverse = startEvent.isBefore(endEvent);
        this.startEvent = noReverse ? startEvent : endEvent;
        this.endEvent = noReverse ? endEvent : startEvent;
    }

    public Duration getDuration() {
        return Duration.between(startEvent, endEvent);
    }

    public static List<TimeInterval> getEvents() {
        return Collections.unmodifiableList(events);
    }

    /**
     * Возвращает ближайший к текущему времени свободный интервал на указанную
     * длительность
     *
     * @param duration длительность события
     * @return ближайший интервал, если такой имеется, либо null
     */
    public TimeInterval next(@NotNull Duration duration) {
        LocalDateTime nextEventStart = LocalDateTime.now();
        LocalDateTime nextEventEnd = nextEventStart.plus(duration);
        TimeInterval interval = new TimeInterval(nextEventStart, nextEventEnd);
        if (check(interval)) {
            return interval;
        }
        return null;
    }

    /**
     * Планирует мероприятие, если его время не перекрывается с другими
     *
     * @param startEvent дата и время начала события
     * @param duration   длительность события
     * @return запланировано или нет
     */
    public static boolean plan(@NotNull LocalDateTime startEvent, @NotNull Duration duration) {
        LocalDateTime endEvent = startEvent.plus(duration);
        TimeInterval interval = new TimeInterval(startEvent, endEvent);
        if (check(interval)) {
            return events.add(interval);
        }
        return false;
    }

    /**
     * Проверяет, не перекрываются ли проверяемый временной интервал
     * с запланированными в событиями
     *
     * @param interval временной интервал
     * @return перекрывается или нет
     */
    public static boolean check(@NotNull TimeInterval interval) {
        if (events.size() == 0) {
            return true;
        }

        for (TimeInterval event : events) {
            if (!(interval.endEvent.compareTo(event.startEvent) <= 0 ||
                    interval.startEvent.compareTo(event.endEvent) >= 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeInterval that = (TimeInterval) o;
        return Objects.equals(startEvent, that.startEvent) &&
                Objects.equals(endEvent, that.endEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startEvent, endEvent);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EVENT\n");
        stringBuilder.append("start: ").append(startEvent).append("\n");
        stringBuilder.append("end: ").append(endEvent).append("\n");
        stringBuilder.append("duration: ").append(getDuration()).append("\n");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
