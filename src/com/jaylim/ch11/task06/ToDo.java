package com.jaylim.ch11.task06;

import java.lang.annotation.*;

@Repeatable(ToDos.class)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToDo {
    String message();
}

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface ToDos {
    ToDo[] value();
}