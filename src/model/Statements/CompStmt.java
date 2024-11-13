package model.Statements;

import Exceptions.MyException;
import model.Structures.MyStack;
import model.Structures.PrgState;

public class CompStmt implements IStmt {
    private final IStmt first;
    private final IStmt second;

    public CompStmt(IStmt first, IStmt second){
        this.first = first;
        this.second = second;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyStack<IStmt> execStack = state.getExeStack();
        execStack.push(second);
        execStack.push(first);
        return state;
    }

    @Override
    public String toString(){
        return  "(" + first.toString() + ", " + second.toString() + ")";
    }
}
