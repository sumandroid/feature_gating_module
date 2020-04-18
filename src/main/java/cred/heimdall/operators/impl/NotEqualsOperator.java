package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;

import java.util.ArrayList;
import java.util.List;

public class NotEqualsOperator implements Operators {
        private static int precedence = 7;
        private static NotEqualsOperator notEqualsOperator;
        private List<String> symbols;
        private int operandCount;

    private NotEqualsOperator(){
        symbols = new ArrayList<>();
        this.symbols.add("!=");
        this.symbols.add("ne");
        this.operandCount = 2;
    }

    public NotEqualsOperator getInstance(){
        if(notEqualsOperator == null){
            notEqualsOperator = new NotEqualsOperator();
        }
        return notEqualsOperator;
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
