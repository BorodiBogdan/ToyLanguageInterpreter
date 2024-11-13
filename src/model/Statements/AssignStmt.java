package model.Statements;

import Exceptions.IncorrectTypeAssign;
import Exceptions.MyException;
import Exceptions.VariableNotDefined;
import model.Expressions.IExpression;
import model.Structures.MyDictionary;
import model.Structures.MyStack;
import model.Structures.PrgState;
import model.Types.IType;
import model.Values.IValue;

public class AssignStmt implements IStmt{
    private final String varName;
    private final IExpression expression;

    public AssignStmt(String varName, IExpression expression){
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyDictionary<String, IValue> symbolTable = state.getSymbolTable();

        if(!symbolTable.exists(varName))
                throw new VariableNotDefined();

        IValue expValue = expression.eval(symbolTable);
        IType varType = symbolTable.get(varName).getType();

        if (!expValue.getType().equals(varType))
            throw new IncorrectTypeAssign();

        symbolTable.add(varName, expValue);

        return state;
    }

    @Override
    public String toString(){
        return varName + "=" + expression.toString();
    }
}
