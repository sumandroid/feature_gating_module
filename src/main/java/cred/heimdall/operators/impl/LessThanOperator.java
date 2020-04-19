package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandType;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LessThanOperator implements Operators {
    private static int precedence = 4;
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if(operands.size() != operandCount){
            throw new OperandCountException("Invalid operand count for LessThan operator");
        }
        Object operand1 = operands.poll();
        Object operand2 = operands.poll();
        if(operand1 instanceof Integer){
            if(operand2 instanceof Integer){
                return ((Integer) operand1 < (Integer) operand2);
            }
            if(operand2 instanceof Float){
                return ((Integer) operand1 < (Float) operand2);
            }
            throw new IllegalArgumentException("Type mismatch of operands for LessThan operator");
        }
        if(operand1 instanceof Float){
            if(operand2 instanceof Float){
                return ((Float) operand1 < (Float) operand2);
            }
            if(operand2 instanceof Integer){
                return ((Float) operand1 < (Integer) operand2);
            }
            throw new IllegalArgumentException("Type mismatch of operands for LessThan operator");
        }
        throw new UnSupportedOperandType("Type not supported for LessThan operator");
    }
}
