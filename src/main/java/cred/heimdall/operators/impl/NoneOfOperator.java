package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class NoneOfOperator implements Operators {
    private static int precedence = 5;
    private static NoneOfOperator noneOfOperator = null;
    private List<String> symbols;
    private int operandCount;

    private NoneOfOperator(){
        symbols = new ArrayList<>();
        symbols.add("nof");
        symbols.add("noneof");
        operandCount = 3;
    }

    public NoneOfOperator getInstance(){
        if(noneOfOperator == null){
            noneOfOperator = new NoneOfOperator();
        }
        return noneOfOperator;
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
