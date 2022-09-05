package com.telran.project.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Application {
    public static void main(String[] args) {

        String ptsOne = "{}()[]";//true
        String ptsTwo = "{)";//false
        String ptsThree = "{[()]}";//true
        String ptsFour = "{([)]}";//false

        Application application = new Application();

        System.out.println("Implementation with Stack :");

        System.out.println("Is valid " + ptsOne + " = " + application.isValid(ptsOne, new Stack<>()));
        System.out.println("Is valid " + ptsTwo + " = " + application.isValid(ptsTwo, new Stack<>()));
        System.out.println("Is valid " + ptsThree + " = " + application.isValid(ptsThree, new Stack<>()));
        System.out.println("Is valid " + ptsFour + " = " + application.isValid(ptsFour, new Stack<>()));

        System.out.println("----------------------------");
        System.out.println("Implementation with ArrayList :");

        System.out.println("Is valid " + ptsOne + " = " + application.isValid(ptsOne, new OurStack<>()));
        System.out.println("Is valid " + ptsTwo + " = " + application.isValid(ptsTwo, new OurStack<>()));
        System.out.println("Is valid " + ptsThree + " = " + application.isValid(ptsThree, new OurStack<>()));
        System.out.println("Is valid " + ptsFour + " = " + application.isValid(ptsFour, new OurStack<>()));

        System.out.println("----------------------------");
        System.out.println("Implementation with LinkedList :");

        System.out.println("Is valid " + ptsOne + " = " + application.isValid(ptsOne, new LinkedStack<>()));
        System.out.println("Is valid " + ptsTwo + " = " + application.isValid(ptsTwo, new LinkedStack<>()));
        System.out.println("Is valid " + ptsThree + " = " + application.isValid(ptsThree, new LinkedStack<>()));
        System.out.println("Is valid " + ptsFour + " = " + application.isValid(ptsFour, new LinkedStack<>()));
    }

    public boolean isValid(String string, Stack<Character> stack) {
        Map<Character, Character> map = getCharacterCharacterMap();
        checkStack(string, stack, map);
        return stack.empty();
    }

    private void checkStack(String string, Stack<Character> stack, Map<Character, Character> map) {
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if (map.containsKey(temp)) {
                char peek = stack.peek();
                if (peek == map.get(temp)) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            } else {
                stack.push(temp);
            }
        }
    }

    private Map<Character, Character> getCharacterCharacterMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        return map;
    }

}

