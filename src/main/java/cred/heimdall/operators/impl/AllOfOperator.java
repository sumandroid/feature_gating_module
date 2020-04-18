package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class AllOfOperator implements Operators {
    private static int precedence = 5;
    private static AllOfOperator allOfOperator = null;
    private List<String> symbols;
    private int operandCount;

    private AllOfOperator(){
        symbols = new ArrayList<>();
        symbols.add("allof");
        symbols.add("aof");
        operandCount = 3;
    }

    public AllOfOperator getInstance(){
        if(allOfOperator == null){
            allOfOperator = new AllOfOperator();
        }
        return allOfOperator;
    }

    @Override
    public int getPrecedence() {
        return 0;
    }

    @Override
    public List<String> getSymbols() {
        return null;
    }

    @Override
    public int getOperandCount() {
        return 0;
    }
}
