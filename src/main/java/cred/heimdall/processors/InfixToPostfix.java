package cred.heimdall.processors;

import cred.heimdall.evaluators.Context;
import cred.heimdall.operators.Operators;
import cred.heimdall.operators.impl.*;
import exceptions.InfixToPostfixException;

import java.util.*;

public class InfixToPostfix {
    private static Set<Operators> operators;
    private static Map<String, Operators> symbolOperatorMap;
    private static InfixToPostfix infixToPostfix = null;

    private InfixToPostfix() {
        populateOperationsSet();
        populateSymbolOperatorMap();
    }

    public static InfixToPostfix getInstance() {
        if (infixToPostfix == null) {
            infixToPostfix = new InfixToPostfix();
        }
        return infixToPostfix;
    }

    public Map<String, Operators> getSymbolOperatorMap() {
        return symbolOperatorMap;
    }

    public Set<Operators> getOperators() {
        return operators;
    }

    public String convert(String infixExpression) {
        if (infixExpression.trim().equals("")) {
            throw new InfixToPostfixException("Empty Infix expression");
        }
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] elements = infixExpression.trim().split(" ");
        for (String element : elements) {
            if (element.equalsIgnoreCase("(")) {
                stack.push(element);
            } else if (element.equalsIgnoreCase(")")) {
                while (!stack.isEmpty() && !stack.peek().equalsIgnoreCase("(")) {
                    res.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && !stack.peek().equalsIgnoreCase("(")) {
                    throw new InfixToPostfixException("invalid expression");
                } else {
                    try{
                        stack.pop();
                    }catch (EmptyStackException e){
                        throw new InfixToPostfixException("invalid expression");
                    }
                }

            } else if (!isOperator(element)) {
                res.append(element).append(" ");
            } else {
                while (!stack.isEmpty() && getPrecendence(element) <= getPrecendence(stack.peek())) {
                    if (stack.peek().equalsIgnoreCase("(")) {
                        throw new InfixToPostfixException("invalid expression");
                    }
                    res.append(stack.pop()).append(" ");
                }
                stack.push(element);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equalsIgnoreCase("(")) {
                throw new InfixToPostfixException("invalid expression");
            }
            res.append(stack.pop()).append(" ");
        }
        return res.toString();
    }


    public Boolean eval(String postFix, Context context) {
        Stack<Object> stack = new Stack<>();
        String[] elements = postFix.split(" ");
        for (String element : elements) {
            if (!isOperator(element)) {
                Object val = context.getAttributeVal(element.toLowerCase());
                if (val != null) {
                    stack.push(val);
                } else if (element.equalsIgnoreCase("true")) {
                    stack.push(true);
                } else if (element.equalsIgnoreCase("false")) {
                    stack.push(false);
                } else {
                    try {
                        int value = Integer.parseInt(element);
                        stack.push(value);
                        continue;
                    } catch (NumberFormatException ignored) {
                    }
                    try {
                        double value = Double.parseDouble(element);
                        stack.push(value);
                        continue;
                    } catch (NumberFormatException ignored) {
                    }
                    stack.push(element);
                }
            } else {
                Operators operator = symbolOperatorMap.get(element);
                int operandCount = operator.getOperandCount();
                List<Object> operandsList = new LinkedList<>();
                for (int i = 0; i < operandCount; i++) {
                    operandsList.add(stack.pop());
                }
                Collections.reverse(operandsList);
                Queue<Object> operands = new LinkedList<>(operandsList);
                Object result = operator.operate(operands);
                stack.push(result);
            }
        }
        return (Boolean) stack.pop();
    }


    private static boolean isOperator(String element) {
        for (String key : symbolOperatorMap.keySet()) {
            if (key.equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }

    private void populateOperationsSet() {
        operators = new HashSet<>();
        operators.add(AllOfOperator.getInstance());
        operators.add(AndOperator.getInstance());
        operators.add(BetweenOperator.getInstance());
        operators.add(EqualsToOperator.getInstance());
        operators.add(GreaterThanEqualToOperator.getInstance());
        operators.add(GreaterThanOperator.getInstance());
        operators.add(LessThanEqualToOperator.getInstance());
        operators.add(LessThanOperator.getInstance());
        operators.add(NoneOfOperator.getInstance());
        operators.add(NotEqualsOperator.getInstance());
        operators.add(NotOperator.getInstance());
        operators.add(OrOperator.getInstance());
        populateSymbolOperatorMap();
    }

    private void populateSymbolOperatorMap() {
        symbolOperatorMap = new HashMap<>();
        for (Operators operator : operators) {
            for (String symbol : operator.getSymbols()) {
                symbolOperatorMap.put(symbol, operator);
            }
        }
    }

    private int getPrecendence(String element) {
        for (String key : symbolOperatorMap.keySet()) {
            if (element.equals(key)) {
                return symbolOperatorMap.get(key).getPrecedence();
            }
        }
        return 0;
    }
}
