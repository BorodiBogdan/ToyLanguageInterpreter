package model.Statements;

import Exceptions.MyException;
import model.Expressions.IExpression;
import model.Structures.MyDictionary;
import model.Structures.MyList;
import model.Structures.PrgState;
import model.Values.IValue;

public class PrintStmt implements IStmt {
    private final IExpression expression;

    public PrintStmt(IExpression expression){
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyDictionary<String, IValue> symbols = state.getSymbolTable();
        IValue valueToPrint = expression.eval(symbols);
        MyList<IValue> out = state.getOut();
        out.add(valueToPrint);
        return state;
    }

    @Override
    public String toString(){
        return "print(" + expression.toString() + ")";
    }
}
