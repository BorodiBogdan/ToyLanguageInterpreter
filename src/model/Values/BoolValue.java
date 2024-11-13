package model.Values;

import model.Types.BoolType;
import model.Types.IType;

public class BoolValue implements IValue {
    private final boolean val;

    public BoolValue(){
        val = false;
    }

    public BoolValue(boolean val){
        this.val = val;
    }

    public boolean getVal(){
        return val;
    }

    @Override
    public IType getType() {
        return new BoolType();
    }
    @Override
    public String toString(){
        return "" + val;
    }
}
