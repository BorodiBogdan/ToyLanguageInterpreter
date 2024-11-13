package model.Types;

import model.Values.IValue;
import model.Values.IntValue;

public class IntType implements IType{
    @Override
    public IValue getDefaultValue(){
        return new IntValue();
    }
    @Override
    public String toString(){
        return "int";
    }
    @Override
    public boolean equals(Object other){
        return other instanceof IntType;
    }
}
