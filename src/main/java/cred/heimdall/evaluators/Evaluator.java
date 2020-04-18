package cred.heimdall.evaluators;

public interface Evaluator {
    boolean evalToBool(Context context, String condition);
}
