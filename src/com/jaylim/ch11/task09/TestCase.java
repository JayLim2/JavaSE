package com.jaylim.ch11.task09;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TestCases.class)
public @interface TestCase {
    String params();

    String expected();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestCases {
    TestCase[] value();
}
