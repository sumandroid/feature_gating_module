package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class GreaterThanEqualToOperator implements Operators {
    private static int precedence = 6;
    private static GreaterThanEqualToOperator greaterThanEqualToOperator = null;
    private List<String> symbols;
    private int operandCount;

    private GreaterThanEqualToOperator(){
        symbols = new ArrayList<>();
        symbols.add(">=");
        symbols.add("gte");
        operandCount = 2;
    }

    public static GreaterThanEqualToOperator getInstance(){
        if(greaterThanEqualToOperator == null){
            greaterThanEqualToOperator = new GreaterThanEqualToOperator();
        }
        return greaterThanEqualToOperator;
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
