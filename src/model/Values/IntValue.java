package model.Values;

import model.Types.BoolType;
import model.Types.IType;
import model.Types.IntType;

public class IntValue implements IValue{
    private final int val;

    public IntValue(){
        val = 0;
    }

    public IntValue(int val){
        this.val = val;
    }

    public int getVal(){
        return val;
    }

    @Override
    public String toString(){
        return "" + val;
    }
    @Override
    public IType getType() {
        return new IntType();
    }
}
