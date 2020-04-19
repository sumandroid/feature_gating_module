package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EqualsToOperator implements Operators {
    private static int precedence = 4;
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if(operands.size() != operandCount){
            throw new OperandCountException("Invalid operand count for EqualsTo operator");
        }
        Object operand1 = operands.poll();
        Object operand2 = operands.poll();
        if(operand1 instanceof String && operand2 instanceof String){
            return ((String) operand1).equalsIgnoreCase((String) operand2);
        }
        if(operand1 != null && operand2 != null){
            return (operand1.equals(operand2));
        }else{
            throw new IllegalArgumentException("Illegal Argument for EqualsTo operator");
        }
    }


}
