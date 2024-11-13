package model.Expressions;

import Exceptions.MyException;
import Exceptions.OperandNotBool;
import model.Structures.MyDictionary;
import model.Types.BoolType;
import model.Values.BoolValue;
import model.Values.IValue;

public class LogicExpression implements IExpression{
    private final IExpression left;
    private final IExpression right;
    private final int sign;

    public LogicExpression(IExpression left, IExpression right, int sign){
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    @Override
    public IValue eval(MyDictionary<String, IValue> symTable) throws MyException {
        IValue firstOperand = left.eval(symTable);

        if(!firstOperand.getType().equals(new BoolType()))
            throw new OperandNotBool();

        IValue secondOperand = right.eval(symTable);

        if(!secondOperand.getType().equals(new BoolType()))
            throw  new OperandNotBool();

        boolean firstValue = ((BoolValue) firstOperand).getVal();
        boolean secondValue = ((BoolValue) secondOperand).getVal();

        if(sign == 1)
            return new BoolValue(firstValue && secondValue);
        else return new BoolValue(firstValue || secondValue);
    }

    @Override
    public String toString(){
        String[] symbolTable = {"", "AND", "OR"};

        return  "(" + left.toString() + symbolTable[this.sign] + right.toString() + ")";
    }
}
