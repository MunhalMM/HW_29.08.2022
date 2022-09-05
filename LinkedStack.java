package com.telran.project.stack;

import java.util.LinkedList;
import java.util.Stack;

public class LinkedStack<E> extends Stack<E> {
    private LinkedList<E> stack;

    public LinkedStack() {
        this.stack = new LinkedList<>();
    }

    public E push(E element) {
        stack.add(element);
        return element;
    }

    public E peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return stack.getLast();
    }

    public E pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        E character = stack.get(stack.size() - 1);
        stack.remove(stack.getLast());
        return character;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}


