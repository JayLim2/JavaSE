package com.jaylim.ch06.task01;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);
        stack.push(9);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
