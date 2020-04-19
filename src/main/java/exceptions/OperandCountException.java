package exceptions;

public class OperandCountException extends RuntimeException {

    public OperandCountException(String message){
        super(message);
    }
}
