package cred.heimdall.operators.impl;

import cred.heimdall.operators.Operators;
import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllOfOperator implements Operators {
    private static int precedence = 5;
    private static AllOfOperator allOfOperator = null;
    private List<String> symbols;
    private int operandCount;

    private AllOfOperator(){
        symbols = new ArrayList<>();
        symbols.add("allof");
        symbols.add("aof");
        operandCount = 3;
    }

    public static AllOfOperator getInstance(){
        if(allOfOperator == null){
            allOfOperator = new AllOfOperator();
        }
        return allOfOperator;
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
            throw new OperandCountException("Invalid operand count for AllOf operator");
        }
        List<Object> operandList = new ArrayList<>();
        while (operands.size() > 0){
            operandList.add(operands.poll());
        }
        EqualsToOperator equalsToOperator = EqualsToOperator.getInstance();
        for(int i = 0; i < operandList.size() - 1; i++){
            for(int j = i+1; j < operandList.size(); j++){
                Queue<Object> objects = new LinkedList<>();
                objects.add(operandList.get(i));
                objects.add(operandList.get(j));
                if(!(Boolean) equalsToOperator.operate(objects)){
                    return false;
                }
            }
        }
        return true;
    }
}
