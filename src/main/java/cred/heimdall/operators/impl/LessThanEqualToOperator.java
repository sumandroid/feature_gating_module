package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class LessThanEqualToOperator implements Operators {
    private static int precedence = 6;
    private static LessThanEqualToOperator lessThanEqualToOperator;
    private List<String> symbols;
    private int operandCount;

    private LessThanEqualToOperator(){
        symbols = new ArrayList<>();
        symbols.add("<=");
        symbols.add("lte");
        operandCount = 2;
    }

    public static LessThanEqualToOperator getInstance(){
        if(lessThanEqualToOperator == null){
            lessThanEqualToOperator = new LessThanEqualToOperator();
        }
        return lessThanEqualToOperator;
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
