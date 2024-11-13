package model.Statements;

import Exceptions.MyException;
import model.Structures.PrgState;

public class NOP implements IStmt {
    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state;
    }

    @Override
    public String toString() {
        return "nop";
    }
}
