package model.Statements;

import Exceptions.ExpressionNotBool;
import Exceptions.MyException;
import model.Expressions.IExpression;
import model.Structures.PrgState;
import model.Types.BoolType;
import model.Values.BoolValue;
import model.Values.IValue;

public class IfStmt implements IStmt {
    private final IExpression exp;
    private final IStmt trueBranch;
    private final IStmt falseBranch;

    public IfStmt(IExpression exp, IStmt trueBranch, IStmt falseBranch) {
        this.exp = exp;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public String toString() {
        return "(IF(" + exp.toString() + ")THEN(" + trueBranch.toString() + ")ELSE(" + falseBranch.toString() + "))";
    }

    public PrgState execute(PrgState state) throws MyException {
        IValue expressionValue = exp.eval(state.getSymbolTable());

       // if (!expressionValue.getType().equals(new BoolType()))
            //throw new ExpressionNotBool();

        if (((BoolValue) expressionValue).getVal())
            state.getExeStack().push(trueBranch);
        else state.getExeStack().push(falseBranch);

        return state;
    }
}