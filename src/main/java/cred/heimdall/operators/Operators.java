package cred.heimdall.operators;

import java.util.List;

public interface Operators {
    int getPrecedence();
    List<String> getSymbols();
    int getOperandCount();
}
