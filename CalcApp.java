package com.telran.project.stack;

import java.util.Stack;

public class CalcApp {
    public static void main(String[] args) {
        String inputData = "4+15-2*7+6";//11  // -, +, *, /

        Stack<Integer> integerStack = new Stack<>();
        CalcApp calcApp = new CalcApp();
        calcApp.calc(integerStack, inputData);
        System.out.println("Sum this expression : " + inputData + "=" + calcApp.printResult(integerStack));

    }

    private void calc(Stack<Integer> stack, String input) {
        int tempInt = 0;
        Operation tempOperation = Operation.PLUS;
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (Character.isDigit(temp)) {
                tempInt = tempInt * 10 + (temp - '0');
            }
            if (!Character.isDigit(temp) || i == input.length() - 1) {
                switch (tempOperation) {
                    case PLUS:
                        stack.push(tempInt);
                        break;
                    case MINUS:
                        stack.push(-tempInt);
                        break;
                    case DIVISION:
                        stack.push(stack.pop() / tempInt);
                        break;
                    case MULTIPLY:
                        stack.push(stack.pop() * tempInt);
                        break;
                    default:

                }
                tempOperation = Operation.getOperationBySymbol(temp);
                tempInt = 0;
            }
        }
    }

    private int printResult(Stack<Integer> stack) {
        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
