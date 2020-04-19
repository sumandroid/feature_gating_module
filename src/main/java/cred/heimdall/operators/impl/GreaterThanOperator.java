package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GreaterThanOperator implements Operators {
    private static int precedence = 4;
    private static GreaterThanOperator greaterThanOperator = null;
    private List<String> symbols;
    private int operandCount;

    private GreaterThanOperator(){
        symbols = new ArrayList<>();
        symbols.add(">");
        symbols.add("gt");
        operandCount = 2;
    }

    public static GreaterThanOperator getInstance(){
        if(greaterThanOperator == null){
            greaterThanOperator = new GreaterThanOperator();
        }
        return greaterThanOperator;
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
            throw new OperandCountException("Invalid operand count for GreaterThanEqualTo operator");
        }
        Object operand1 = operands.poll();
        Object operand2 = operands.poll();
        if(operand1 instanceof Integer){
            if(operand2 instanceof Integer){
                return ((Integer) operand1 > (Integer) operand2);
            }
            if(operand2 instanceof Float){
                return ((Integer) operand1 > (Float) operand2);
            }
            throw new IllegalArgumentException("Type mismatch of operands for GreaterThan operator");
        }
        if(operand1 instanceof Float){
            if(operand2 instanceof Float){
                return ((Float) operand1 > (Float) operand2);
            }
            if(operand2 instanceof Integer){
                return ((Float) operand1 > (Integer) operand2);
            }
            throw new IllegalArgumentException("Type mismatch of operands for GreaterThan operator");
        }
        throw new UnSupportedOperandTypeException("Type not supported for GreaterThan operator");
    }
}
