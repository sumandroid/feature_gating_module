package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PlusOperator implements Operators {
    private static final int precedence = 6;
    private volatile static PlusOperator plusOperator = null;
    private List<String> symbols;
    private static final int operandCount = 2;

    private PlusOperator() {
        symbols = new ArrayList<>();
        symbols.add("+");
        symbols.add("add");
    }

    public static PlusOperator getInstance() {
        if (plusOperator == null) {
            synchronized (PlusOperator.class) {
                if (plusOperator == null) {
                    plusOperator = new PlusOperator();
                }
            }
        }
        return plusOperator;
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
        if (operands.size() != operandCount) {
            throw new OperandCountException("operand count mismatch for add operator");
        }
        Object operand1 = operands.poll();
        Object operand2 = operands.poll();
        if (operand1 instanceof Integer) {
            if (operand2 instanceof Integer) {
                return (Integer) operand1 + (Integer) operand2;
            }
            if (operand2 instanceof Float) {
                return (Integer) operand1 + (Float) operand2;
            }
        } else if (operand1 instanceof Float) {
            if (operand2 instanceof Integer) {
                return (Float) operand1 + (Integer) operand2;
            }
            if (operand2 instanceof Float) {
                return (Float) operand1 + (Float) operand2;
            }
        }
        throw new IllegalArgumentException("unsupported type for add operator");
    }
}
