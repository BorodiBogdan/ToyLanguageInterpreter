package model.Expressions;

import model.Structures.MyDictionary;
import model.Values.IValue;

public class ValueExp implements IExpression{
    private final IValue value;

    public ValueExp(IValue value){
        this.value = value;
    }

    @Override
    public IValue eval(MyDictionary<String, IValue> symTable) {
        return this.value;
    }

    @Override
    public String toString() {
        return "" + this.value.toString();
    }
}
