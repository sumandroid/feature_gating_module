package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class GreaterThanOperator implements Operators {
    private static int precedence = 6;
    private static GreaterThanOperator greaterThanOperator = null;
    private List<String> symbols;
    private int operandCount;

    private GreaterThanOperator(){
        symbols = new ArrayList<>();
        symbols.add(">");
        symbols.add("gt");
        operandCount = 2;
    }

    public GreaterThanOperator getInstance(){
        if(greaterThanOperator == null){
            greaterThanOperator = new GreaterThanOperator();
        }
        return greaterThanOperator;
    }
    @Override
    public int getPrecedence() {
        return precedence;
    }

    @Override
    public List<String> getSymbols() {
        return symbols;
    }

    @Override
    public int getOperandCount() {
        return operandCount;
    }
}
