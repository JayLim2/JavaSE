package com.jaylim.ch06.task02;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
