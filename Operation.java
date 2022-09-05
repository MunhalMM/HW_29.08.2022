package com.telran.project.stack;

public enum Operation {
    PLUS('+'),
    MINUS('-'),
    DIVISION('/'),
    MULTIPLY('*');

    private char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public char getOperationSymbol() {
        return operationSymbol;
    }

    public static Operation getOperationBySymbol(char operationSymbol) {
        for (Operation operation : values()) {
            if (operation.operationSymbol == operationSymbol) {
                return operation;
            }
        }
        return null;
    }
}
