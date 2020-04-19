package cred.heimdall.operators.impl;
import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class OrOperator implements Operators {
    private static int precedence = 1;
    private static List<String> symbols;
    private static OrOperator orOperator = null;
    private int operandCount;

    private OrOperator() {
        symbols = new ArrayList<>();
        symbols.add("||");
        symbols.add("or");
        operandCount = 2;
    }

    public static OrOperator getInstance() {
        if (orOperator == null) {
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if (operands.size() != operandCount) {
            throw new OperandCountException("Invalid operand count for OR operator");
        }
        Object operand1 = operands.poll();
        Object operand2 = operands.poll();
        if (operand1 instanceof Boolean && operand2 instanceof Boolean) {
            if ((Boolean) operand1 || (Boolean) operand2) {
                return true;
            }
            return false;
        }
        throw new UnSupportedOperandTypeException("Unsupported operand type for OR operator");
    }
}
