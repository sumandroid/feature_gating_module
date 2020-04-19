package cred.heimdall.evaluators.impl;

import cred.heimdall.processors.InfixToPostfix;
import cred.heimdall.evaluators.Context;
import cred.heimdall.evaluators.Evaluator;

public class EvalPostFixToBool implements Evaluator {

    private static InfixToPostfix infixToPostfix;

    public EvalPostFixToBool(){
       infixToPostfix = InfixToPostfix.getInstance();
    }

    @Override
    public boolean eval(Context context, String condition) {
        String postFix = infixToPostfix.convert(condition);
        System.out.println("Postfix expression is : " + postFix);
        return infixToPostfix.eval(postFix, context);
    }

}
