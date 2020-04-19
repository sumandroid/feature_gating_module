package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AndOperator implements Operators {
    private static int precedence = 2;
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if(operands.size() != operandCount){
            throw new OperandCountException("Invalid operand count for AND operator");
        }
        Object operand1 = operands.poll();
        Object operand2 = operands.poll();
        if(operand1 != null && operand2 != null){
            if(operand1 instanceof Boolean && operand2 instanceof Boolean){
                if((Boolean) operand1 && (Boolean) operand2){
                    return true;
                }
                return false;
            }else{
                throw new UnSupportedOperandTypeException("Unsupported operands for And operator");
            }
        }
        throw new IllegalArgumentException("Illegal Arguments for And operator");
    }
}
