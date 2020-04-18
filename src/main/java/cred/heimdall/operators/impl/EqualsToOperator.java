package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class EqualsToOperator implements Operators {
    private static int precedence = 7;
    private static EqualsToOperator equalsToOperator;
    private List<String> symbols;
    private int operandCount;

    private EqualsToOperator(){
        symbols = new ArrayList<>();
        symbols.add("==");
        symbols.add("eq");
        operandCount = 2;
    }

    public static EqualsToOperator getInstance(){
        if(equalsToOperator == null){
             equalsToOperator = new EqualsToOperator();
        }
        return equalsToOperator;
    }

    public int getPrecedence(){
        return precedence;
    }

    public List<String> getSymbols(){
        return symbols;
    }

    public int getOperandCount(){
        return operandCount;
    }



}
