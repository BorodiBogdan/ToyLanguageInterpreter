package model.Expressions;

import Exceptions.MyException;
import model.Structures.MyDictionary;
import model.Values.IValue;

public interface IExpression {
    IValue eval(MyDictionary<String,IValue> symTable) throws MyException;
}
