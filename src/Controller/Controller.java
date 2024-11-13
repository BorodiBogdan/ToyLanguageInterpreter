package Controller;

import Exceptions.EmptyExecutionStack;
import Exceptions.MyException;
import model.Structures.PrgState;
import model.Statements.IStmt;
import Repository.IRepository;

public class Controller {
    private final IRepository repo;

    public Controller(IRepository r) {
        repo = r;
    }

    public PrgState executeOne(PrgState state) throws MyException {
        if (state.getExeStack().isEmpty())
            throw new EmptyExecutionStack();

        IStmt currentStatement = state.getExeStack().pop();

        try {
            return currentStatement.execute(state);
        } catch (MyException e) {
            state.getExeStack().push(currentStatement);
            throw e;
        }
    }

    public String executeAll() throws MyException {
        PrgState program = repo.getCurentState();

        StringBuilder output = new StringBuilder();

        if (program.getExeStack().isEmpty())
            throw new EmptyExecutionStack();

        while (!program.getExeStack().isEmpty()) {
            output.append(program);
            PrgState _ = executeOne(program);
        }
        output.append(program);
        return output.toString();
    }
}
