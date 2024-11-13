package model.Statements;

import Exceptions.DoubleDeclaration;
import Exceptions.MyException;
import model.Structures.MyDictionary;
import model.Structures.PrgState;
import model.Types.IType;
import model.Values.IValue;

public class VarDeclStmt implements IStmt{
    private final String varName;
    private final IType varType;

    public VarDeclStmt(String varName, IType varType){
        this.varType = varType;
        this.varName = varName;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        if(state.getSymbolTable().exists(varName))
            throw new DoubleDeclaration();

        state.getSymbolTable().add(varName, varType.getDefaultValue());

        return state;
    }

    @Override
    public String toString(){
        return "(" + varType.toString() + " " + varName + ")";
    }
}
