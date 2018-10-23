package com.jaylim;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class TempClass {
    public static void main(String[] args) throws IntrospectionException {
        //no exercise

        /*Class<?> cl = TestBean.class;
        BeanInfo info = Introspector.getBeanInfo(cl);
        PropertyDescriptor[] props = info.getPropertyDescriptors();
        for (PropertyDescriptor prop : props) {
            System.out.println(prop.getDisplayName() + " " + prop.getPropertyType());
        }*/
        /*Logger.getGlobal().info("aaaa");
        Logger logger = Logger.getLogger("custom");
        logger.warning("blabal");*/

        //test(new Manager[] {new Manager(), new Manager()});

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(5);
        queue.add(1);
        queue.add(7);
        while (queue.size() > 0) {
            System.out.println(queue.remove());
        }

        int i = 0;
        Stream<String> stringStream = Stream.generate(() ->
                "echo"
        ).limit(10);
        stringStream.forEach(System.out::println);
    }

    public int a(String a) {
        return 0;
    }

    public int a(Integer a) {
        return 0;
    }

    public static void test(Employee[] arr) {

        System.out.println("hello world");
    }

    public static void test2(ArrayList<? extends Employee> arr) {
        arr.add(10, null);
    }

    public static <T> void test3(T... arr) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : arr) {
            list.add(t);
        }
    }

    private static class Manager extends Employee {
    }

    private static class Employee {
    }
}

class TestBean {
    private int id;

    public TestBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}