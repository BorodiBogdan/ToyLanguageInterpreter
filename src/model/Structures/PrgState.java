package model.Structures;

import model.Statements.IStmt;
import model.Values.IValue;

public class PrgState {
    private  MyDictionary<String, IValue> symbolTable;
    private MyStack<IStmt> exeStack;
    private MyList<IValue> output;

    public PrgState(MyStack<IStmt> stack, MyList<IValue> out, MyDictionary<String, IValue> symTable){
        exeStack = stack;
        symbolTable = symTable;
        this.output = out;
    }

    public MyList<IValue> getOut(){
        return  output;
    }
    public  MyStack<IStmt> getExeStack(){
        return exeStack;
    }
    public MyDictionary<String, IValue> getSymbolTable(){
        return this.symbolTable;
    }

    public void setSymbolTable(MyDictionary<String, IValue> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public void setExeStack(MyStack<IStmt> exeStack){
        this.exeStack = exeStack;
    }

    public void setOutput(MyList<IValue> output){
        this.output = output;
    }

    @Override
    public String toString() {
        return "Execution Stack: " + exeStack.toString() + "\nSymbol table: " + symbolTable.toString() + "\nOutput: " + output.toString() + "\n";
    }
}
