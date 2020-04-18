package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class BetweenOperator implements Operators {
    private static int precedence = 5;
    private static BetweenOperator betweenOperator = null;
    private List<String> symbols;
    private int operandCount;

    private BetweenOperator(){
        symbols = new ArrayList<>();
        symbols.add("between");
        symbols.add("b/w");
        operandCount = 3;
    }

    public BetweenOperator getInstance(){
        if(betweenOperator == null){
            betweenOperator = new BetweenOperator();
        }
        return betweenOperator;
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
