package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandType;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public static BetweenOperator getInstance(){
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if(operands.size() != operandCount){
            throw new OperandCountException("Invalid operand count for BETWEEN operator");
        }
        Object attribute = operands.poll();
        Object start = operands.poll();
        Object end = operands.poll();
        if(attribute instanceof Integer){
            if(start instanceof Integer && end instanceof Integer){
                return ((Integer) attribute >= (Integer) start &&
                        (Integer) attribute <= (Integer) end);
            }
            throw new IllegalArgumentException("Type mismatch for operands");
        }
        if(attribute instanceof Float){
            if(start instanceof Float && end instanceof Float){
                return ((Float) attribute >= (Float) start &&
                        (Float) attribute <= (Float) end);
            }
            throw new IllegalArgumentException("Type mismatch for operands");
        }
        throw new UnSupportedOperandType("Unsupported types for Between operator");
    }
}
