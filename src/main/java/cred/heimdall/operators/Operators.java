package cred.heimdall.operators;

import java.util.List;
import java.util.Queue;

public interface Operators {
    int getPrecedence();
    List<String> getSymbols();
    int getOperandCount();
    Object operate(Queue<Object> operands) throws RuntimeException;
}
