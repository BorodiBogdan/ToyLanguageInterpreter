package model.Expressions;

import Exceptions.MyException;
import Exceptions.VariableNotDefined;
import model.Structures.MyDictionary;
import model.Values.IValue;
import model.Values.IntValue;

public class VarExp implements IExpression{
    private final String variableName;

    public VarExp(String variableName){
        this.variableName = variableName;
    }

    @Override
    public IValue eval(MyDictionary<String, IValue> symTable) throws MyException {
        if(!symTable.exists(variableName))
            throw new VariableNotDefined();

        return symTable.get(variableName);
    }

    @Override
    public String toString(){
        return variableName;
    }
}
