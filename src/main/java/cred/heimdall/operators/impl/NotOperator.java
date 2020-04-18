package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class NotOperator implements Operators {
    private static int precedence = 2;
    private static List<String> symbols;
    private NotOperator notOperator = null;
    private int operandCount;

    private NotOperator(){
        symbols = new ArrayList<>();
        symbols.add("!");
        symbols.add("not");
        operandCount = 1;
    }

    public NotOperator getInstance(){
        if(notOperator == null){
            notOperator = new NotOperator();
        }
        return notOperator;
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
