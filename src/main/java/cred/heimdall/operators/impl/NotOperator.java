package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NotOperator implements Operators {
    private static int precedence = 3;
    private static List<String> symbols;
    private static NotOperator notOperator = null;
    private int operandCount;

    private NotOperator(){
        symbols = new ArrayList<>();
        symbols.add("!");
        symbols.add("not");
        operandCount = 1;
    }

    public static NotOperator getInstance(){
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if(operands.size() != operandCount){
            throw new OperandCountException("Invalid operand count for Not operator");
        }
        Object operand = operands.poll();
        if(operand instanceof Boolean){
            return !(Boolean) operand;
        }
        throw new UnSupportedOperandTypeException("Unsupported operand type for Not operator");
    }
}
