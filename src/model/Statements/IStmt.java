package model.Statements;

import Exceptions.MyException;
import model.Structures.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException;
}

