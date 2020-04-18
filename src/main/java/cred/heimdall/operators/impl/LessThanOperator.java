package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class LessThanOperator implements Operators {
    private static int precedence = 6;
    private static LessThanOperator lessThanOperator;
    private List<String> symbols;
    private int operandCount;

    private LessThanOperator(){
        symbols = new ArrayList<>();
        this.symbols.add("<");
        this.symbols.add("lt");
        this.operandCount = 2;
    }

    public static LessThanOperator getInstance(){
        if(lessThanOperator == null){
            lessThanOperator = new LessThanOperator();
        }
        return lessThanOperator;
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
