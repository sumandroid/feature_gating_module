package cred.heimdall.evaluators.impl;

import cred.heimdall.converters.InfixToPostfix;
import cred.heimdall.evaluators.Context;
import cred.heimdall.evaluators.Evaluator;

public class EvalToBool implements Evaluator {

    @Override
    public boolean eval(Context context, String condition) {
        InfixToPostfix.getInstance().convert(condition);
        return false;
    }

}
