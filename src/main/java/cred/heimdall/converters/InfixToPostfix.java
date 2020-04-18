package cred.heimdall.converters;

import cred.heimdall.operators.Operators;
import cred.heimdall.operators.impl.*;
import exceptions.InfixToPostfixException;

import java.util.*;

public class InfixToPostfix {
    private static Set<Operators> operators;
    private static Map<String, Operators> symbolOperatorMap;
    private static InfixToPostfix infixToPostfix = null;

    private InfixToPostfix(){
        populateOperationsSet();
        populateSymbolOperatorMap();
    }

    public static InfixToPostfix getInstance(){
        if(infixToPostfix == null){
            infixToPostfix = new InfixToPostfix();
        }
        return infixToPostfix;
    }

    public String convert(String infixExpression){
        if(infixExpression.trim().equals("")){
            throw new InfixToPostfixException("Empty Infix expression");
        }
        String res = "";
        Stack<String> stack = new Stack<>();
        String[] elements = infixExpression.trim().split(" ");
        for(String element : elements){
            if(element.equalsIgnoreCase("(")){
                stack.push(element);
            }else if(!isOperator(element)){

            }
        }
        return res;
    }



    private static boolean isOperator(String element){
        return true;
    }

    private void populateOperationsSet(){
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

    private void populateSymbolOperatorMap(){
        symbolOperatorMap = new HashMap<>();
        for(Operators operator : operators){
            for(String symbol : operator.getSymbols()){
                symbolOperatorMap.put(symbol, operator);
            }
        }
    }
}
