package model.Expressions;

import Exceptions.DivisionByZero;
import Exceptions.OperandNotInt;
import model.Structures.MyDictionary;
import model.Types.IntType;
import model.Values.IValue;
import model.Values.IntValue;

public class ArithExp implements IExpression{
    private final IExpression left;
    private final IExpression right;
    private final int operation;

    public ArithExp(int operation, IExpression left, IExpression right){
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        char[] symbolTable = {' ', '+', '-', '/', '*'};

        return left.toString() + symbolTable[this.operation] + right.toString();
    }

    @Override
    public IValue eval(MyDictionary<String, IValue> symTable) {
        IValue firstOperand = left.eval(symTable);
        if (!firstOperand.getType().equals(new IntType()))
            throw new OperandNotInt();

        IValue secondOperand = right.eval(symTable);
        if (!secondOperand.getType().equals(new IntType()))
            throw new OperandNotInt();

        int firstValue = ((IntValue) firstOperand).getVal();
        int secondValue = ((IntValue) secondOperand).getVal();

        if (operation == 1) {
            return new IntValue(firstValue + secondValue);
        }
        else if (operation == 2) {
            return new IntValue(firstValue - secondValue);
        }else if (operation == 3) {
            if (secondValue == 0)
                throw new DivisionByZero();
            return new IntValue(firstValue / secondValue);
        }else {
            return new IntValue(firstValue * secondValue);
        }
    }
}
