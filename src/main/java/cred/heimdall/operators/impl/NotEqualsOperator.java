package cred.heimdall.operators.impl;
import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NotEqualsOperator implements Operators {
        private static int precedence = 4;
        private static NotEqualsOperator notEqualsOperator;
        private List<String> symbols;
        private int operandCount;

    private NotEqualsOperator(){
        symbols = new ArrayList<>();
        this.symbols.add("!=");
        this.symbols.add("ne");
        this.operandCount = 2;
    }

    public static NotEqualsOperator getInstance(){
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

    @Override
    public Object operate(Queue<Object> operands) throws RuntimeException {
        if(operands.size() != operandCount){
            throw new OperandCountException("Invalid operand count for NotEqualsTo operator");
        }
        EqualsToOperator equalsToOperator = EqualsToOperator.getInstance();
        return !(Boolean)equalsToOperator.operate(operands);
    }
}
