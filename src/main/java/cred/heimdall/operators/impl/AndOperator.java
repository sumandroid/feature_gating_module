package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class AndOperator implements Operators {
    private static int precedence = 11;
    private static List<String> symbols;
    private static AndOperator andOperator = null;
    private int operandCount;

    private AndOperator(){
        symbols = new ArrayList<>();
        symbols.add("&&");
        symbols.add("and");
        operandCount = 2;
    }

    public static AndOperator getInstance(){
        if(andOperator == null){
            andOperator = new AndOperator();
        }
        return andOperator;
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
