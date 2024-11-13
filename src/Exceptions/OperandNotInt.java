package Exceptions;

public class OperandNotInt extends MyException {
    public OperandNotInt() {
        super("The operand should be an integer!");
    }
}
