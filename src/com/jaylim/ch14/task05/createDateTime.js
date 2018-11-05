var dt = java.time.ZonedDateTime.of(java.time.LocalDate.of(2013, 1, 1), java.time.LocalTime.of(10, 0), java.time.ZoneId.of("Europe/Samara"));

/*
После этого команды
dt
dt.plusYear(100);
и т.д.

выводят сразу результат

это немного проще, чем перевыполнять каждый раз компиляцию Java кода
с целью проверить какие-либо изменения
 */