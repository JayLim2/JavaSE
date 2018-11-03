package com.jaylim.ch11.task07;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Params.class)
public @interface Param {
    Class<?> type();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Params {
    Param[] value();
}
