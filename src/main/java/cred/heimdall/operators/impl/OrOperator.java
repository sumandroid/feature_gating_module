package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class OrOperator implements Operators {
    private static int precedence = 12;
    private static List<String> symbols;
    private OrOperator orOperator = null;
    private int operandCount;

    private OrOperator(){
        symbols = new ArrayList<>();
        symbols.add("||");
        symbols.add("or");
        operandCount = 2;
    }

    public OrOperator getInstance(){
        if(orOperator == null){
            orOperator = new OrOperator();
        }
        return orOperator;
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
