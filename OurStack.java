package com.telran.project.stack;

import java.util.ArrayList;
import java.util.Stack;



public class OurStack<E> extends Stack<E> {
    private ArrayList<E> stack;

    public OurStack() {

        this.stack = new ArrayList<>();
    }

    public E push(E element) {
        stack.add(element);
        return element;
    }

    public E peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return stack.get(stack.size() - 1);
    }

    public E pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        E character = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return character;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
